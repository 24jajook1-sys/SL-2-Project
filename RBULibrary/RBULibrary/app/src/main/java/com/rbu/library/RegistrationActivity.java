package com.rbu.library;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    EditText etEmail, etName, etPhone;
    Spinner spinnerBranch, spinnerSection, spinnerYear;
    Button btnSubmit;

    String[] branches = {"CSE", "IT", "ECE", "EEE", "MECH", "CIVIL", "AIDS", "AIML"};
    String[] sections = {"A", "B", "C", "D"};
    String[] years = {"1st Year", "2nd Year", "3rd Year", "4th Year"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etEmail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        spinnerBranch = findViewById(R.id.spinnerBranch);
        spinnerSection = findViewById(R.id.spinnerSection);
        spinnerYear = findViewById(R.id.spinnerYear);
        btnSubmit = findViewById(R.id.btnSubmit);

        spinnerBranch.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, branches));
        spinnerSection.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sections));
        spinnerYear.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, years));

        btnSubmit.setOnClickListener(v -> validateAndSubmit());
    }

    private void validateAndSubmit() {
        String email = etEmail.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String branch = spinnerBranch.getSelectedItem().toString();
        String section = spinnerSection.getSelectedItem().toString();
        String year = spinnerYear.getSelectedItem().toString();

        if (TextUtils.isEmpty(name)) {
            etName.setError("Name is required");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Email is required");
            return;
        }
        if (!email.endsWith("@rbunagpur.in")) {
            etEmail.setError("Invalid! Must be a @rbunagpur.in college email");
            return;
        }
        if (TextUtils.isEmpty(phone) || phone.length() != 10) {
            etPhone.setError("Enter valid 10-digit phone number");
            return;
        }

        Intent intent = new Intent(this, BookCategoryActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        intent.putExtra("branch", branch);
        intent.putExtra("section", section);
        intent.putExtra("year", year);
        startActivity(intent);
    }
}
