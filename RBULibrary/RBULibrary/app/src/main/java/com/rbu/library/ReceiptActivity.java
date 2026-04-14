package com.rbu.library;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        int    receiptNo    = getIntent().getIntExtra("receiptNo", 1);
        String bookTitle    = getIntent().getStringExtra("bookTitle");
        String borrowerName = getIntent().getStringExtra("borrowerName");
        String email        = getIntent().getStringExtra("email");
        String takeDate     = getIntent().getStringExtra("takeDate");
        String returnDate   = getIntent().getStringExtra("returnDate");
        String author       = getIntent().getStringExtra("author");

        TextView tvReceiptNo    = findViewById(R.id.tvReceiptNo);
        TextView tvBookTitle    = findViewById(R.id.tvBookTitle);
        TextView tvAuthor       = findViewById(R.id.tvAuthor);
        TextView tvBorrowerName = findViewById(R.id.tvBorrowerName);
        TextView tvEmail        = findViewById(R.id.tvEmail);
        TextView tvTakeDate     = findViewById(R.id.tvTakeDate);
        TextView tvReturnDate   = findViewById(R.id.tvReturnDate);
        TextView tvReminder     = findViewById(R.id.tvReminder);
        Button   btnDone        = findViewById(R.id.btnDone);

        tvReceiptNo.setText("Receipt No: #" + receiptNo);
        tvBookTitle.setText("Book: " + bookTitle);
        tvAuthor.setText("Author: " + author);
        tvBorrowerName.setText("Student: " + borrowerName);
        tvEmail.setText("Email: " + email);
        tvTakeDate.setText("Date of Taking: " + takeDate);
        tvReturnDate.setText("Date of Return: " + returnDate);
        tvReminder.setText("✉ A reminder will be sent to " + email + " one day before the return date.");

        btnDone.setOnClickListener(v -> {
            finishAffinity(); // Go back to home
            startActivity(getIntent().setClass(this, MainActivity.class));
        });
    }
}
