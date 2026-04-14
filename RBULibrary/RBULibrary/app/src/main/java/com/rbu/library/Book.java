package com.rbu.library;

public class Book {
    public String title;
    public String author;
    public String type;
    public String description;
    public int imageResId;

    public Book(String title, String author, String type, String description, int imageResId) {
        this.title       = title;
        this.author      = author;
        this.type        = type;
        this.description = description;
        this.imageResId  = imageResId;
    }
}
