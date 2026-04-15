package com.example.slproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class BookCategoryActivity extends AppCompatActivity {

    String studentName, studentEmail, studentPhone, branch, section, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category);

        studentName  = getIntent().getStringExtra("name");
        studentEmail = getIntent().getStringExtra("email");
        studentPhone = getIntent().getStringExtra("phone");
        branch       = getIntent().getStringExtra("branch");
        section      = getIntent().getStringExtra("section");
        year         = getIntent().getStringExtra("year");

        setupCategoryButton(R.id.btnNovel,         "Novel");
        setupCategoryButton(R.id.btnAutobiography, "Autobiography");
        setupCategoryButton(R.id.btnEngineering,   "Engineering College");
        setupCategoryButton(R.id.btnNeet,          "NEET Books");
        setupCategoryButton(R.id.btnJee,           "JEE Books");
        setupCategoryButton(R.id.btnMotivational,  "Motivational");
    }

    private void setupCategoryButton(int buttonId, String category) {
        Button btn = findViewById(buttonId);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, BookListActivity.class);
            intent.putExtra("category",    category);
            intent.putExtra("name",        studentName);
            intent.putExtra("email",       studentEmail);
            intent.putExtra("phone",       studentPhone);
            intent.putExtra("branch",      branch);
            intent.putExtra("section",     section);
            intent.putExtra("year",        year);
            startActivity(intent);
        });
    }
}
