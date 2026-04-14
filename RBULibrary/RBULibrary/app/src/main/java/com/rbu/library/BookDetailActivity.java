package com.rbu.library;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BookDetailActivity extends AppCompatActivity {

    EditText etBorrowerName, etTakeDate, etReturnDate;
    Button btnPickTakeDate, btnPickReturnDate, btnBookRegister;
    TextView tvBookTitle, tvAuthor, tvType, tvDescription;
    ImageView imgBook;

    String bookTitle, bookAuthor, bookType, bookDescription;
    String studentName, studentEmail;
    int imageResId;

    Calendar takeCalendar   = Calendar.getInstance();
    Calendar returnCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookTitle       = getIntent().getStringExtra("title");
        bookAuthor      = getIntent().getStringExtra("author");
        bookType        = getIntent().getStringExtra("type");
        bookDescription = getIntent().getStringExtra("description");
        imageResId      = getIntent().getIntExtra("imageResId", R.drawable.ic_book);
        studentName     = getIntent().getStringExtra("name");
        studentEmail    = getIntent().getStringExtra("email");

        tvBookTitle   = findViewById(R.id.tvBookTitle);
        tvAuthor      = findViewById(R.id.tvAuthor);
        tvType        = findViewById(R.id.tvType);
        tvDescription = findViewById(R.id.tvDescription);
        imgBook       = findViewById(R.id.imgBookDetail);

        etBorrowerName    = findViewById(R.id.etBorrowerName);
        etTakeDate        = findViewById(R.id.etTakeDate);
        etReturnDate      = findViewById(R.id.etReturnDate);
        btnPickTakeDate   = findViewById(R.id.btnPickTakeDate);
        btnPickReturnDate = findViewById(R.id.btnPickReturnDate);
        btnBookRegister   = findViewById(R.id.btnBookRegister);

        tvBookTitle.setText(bookTitle);
        tvAuthor.setText("Author: " + bookAuthor);
        tvType.setText("Type: " + bookType);
        tvDescription.setText(bookDescription);
        imgBook.setImageResource(imageResId);
        etBorrowerName.setText(studentName);

        btnPickTakeDate.setOnClickListener(v -> showDatePicker(takeCalendar, etTakeDate, true));
        btnPickReturnDate.setOnClickListener(v -> showDatePicker(returnCalendar, etReturnDate, false));
        btnBookRegister.setOnClickListener(v -> submitBookRegistration());
    }

    private void showDatePicker(Calendar cal, EditText target, boolean isTakeDate) {
        DatePickerDialog dpd = new DatePickerDialog(this, (view, year, month, day) -> {
            cal.set(year, month, day);
            cal.set(Calendar.HOUR_OF_DAY, 9);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            target.setText(sdf.format(cal.getTime()));
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));

        if (isTakeDate) {
            dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        } else {
            dpd.getDatePicker().setMinDate(takeCalendar.getTimeInMillis() + 86_400_000L);
        }
        dpd.show();
    }

    private void submitBookRegistration() {
        String borrower = etBorrowerName.getText().toString().trim();
        String takeDate = etTakeDate.getText().toString().trim();
        String retDate  = etReturnDate.getText().toString().trim();

        if (borrower.isEmpty()) { etBorrowerName.setError("Name required"); return; }
        if (takeDate.isEmpty()) { Toast.makeText(this, "Select date of taking", Toast.LENGTH_SHORT).show(); return; }
        if (retDate.isEmpty())  { Toast.makeText(this, "Select date of returning", Toast.LENGTH_SHORT).show(); return; }

        // Generate receipt number (auto-increment)
        SharedPreferences prefs = getSharedPreferences("RBULibrary", MODE_PRIVATE);
        int receiptNo = prefs.getInt("receiptCounter", 0) + 1;
        prefs.edit().putInt("receiptCounter", receiptNo).apply();

        // Schedule WorkManager email reminder 1 day before return date
        scheduleEmailReminder(retDate);

        Intent intent = new Intent(this, ReceiptActivity.class);
        intent.putExtra("receiptNo",    receiptNo);
        intent.putExtra("bookTitle",    bookTitle);
        intent.putExtra("borrowerName", borrower);
        intent.putExtra("email",        studentEmail);
        intent.putExtra("takeDate",     takeDate);
        intent.putExtra("returnDate",   retDate);
        intent.putExtra("author",       bookAuthor);
        startActivity(intent);
    }

    private void scheduleEmailReminder(String returnDateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            Date returnDate = sdf.parse(returnDateStr);
            if (returnDate == null) return;

            long delayMillis = returnDate.getTime() - 86_400_000L - System.currentTimeMillis();
            if (delayMillis <= 0) return;

            Data inputData = new Data.Builder()
                    .putString("email",      studentEmail)
                    .putString("bookTitle",  bookTitle)
                    .putString("returnDate", returnDateStr)
                    .build();

            OneTimeWorkRequest reminderWork = new OneTimeWorkRequest.Builder(EmailReminderWorker.class)
                    .setInitialDelay(delayMillis, TimeUnit.MILLISECONDS)
                    .setInputData(inputData)
                    .addTag("reminder_" + bookTitle)
                    .setConstraints(new Constraints.Builder()
                            .setRequiredNetworkType(NetworkType.CONNECTED)
                            .build())
                    .build();

            WorkManager.getInstance(getApplicationContext()).enqueue(reminderWork);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
