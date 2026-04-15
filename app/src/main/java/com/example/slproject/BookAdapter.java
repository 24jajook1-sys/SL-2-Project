package com.example.slproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    Context context;
    List<Book> bookList;
    String studentName, studentEmail, studentPhone, branch, section, year;

    public BookAdapter(Context context, List<Book> bookList,
                       String studentName, String studentEmail, String studentPhone,
                       String branch, String section, String year) {
        this.context      = context;
        this.bookList     = bookList;
        this.studentName  = studentName;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.branch       = branch;
        this.section      = section;
        this.year         = year;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.tvTitle.setText(book.title);
        holder.tvAuthor.setText("By " + book.author);
        holder.tvType.setText(book.type);
        holder.imgBook.setImageResource(book.imageResId);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, BookDetailActivity.class);
            intent.putExtra("title",       book.title);
            intent.putExtra("author",      book.author);
            intent.putExtra("type",        book.type);
            intent.putExtra("description", book.description);
            intent.putExtra("imageResId",  book.imageResId);
            intent.putExtra("name",        studentName);
            intent.putExtra("email",       studentEmail);
            intent.putExtra("phone",       studentPhone);
            intent.putExtra("branch",      branch);
            intent.putExtra("section",     section);
            intent.putExtra("year",        year);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return bookList.size(); }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBook;
        TextView tvTitle, tvAuthor, tvType;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBook  = itemView.findViewById(R.id.imgBook);
            tvTitle  = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvType   = itemView.findViewById(R.id.tvType);
        }
    }
}
