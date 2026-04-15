package com.example.slproject;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        String category    = getIntent().getStringExtra("category");
        String studentName = getIntent().getStringExtra("name");
        String studentEmail= getIntent().getStringExtra("email");
        String studentPhone= getIntent().getStringExtra("phone");
        String branch      = getIntent().getStringExtra("branch");
        String section     = getIntent().getStringExtra("section");
        String year        = getIntent().getStringExtra("year");

        TextView tvCategory = findViewById(R.id.tvCategoryTitle);
        tvCategory.setText(category);

        RecyclerView recyclerView = findViewById(R.id.recyclerBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Book> books = BookDataSource.getBooksForCategory(category);
        BookAdapter adapter = new BookAdapter(this, books,
                studentName, studentEmail, studentPhone, branch, section, year);
        recyclerView.setAdapter(adapter);
    }
}
