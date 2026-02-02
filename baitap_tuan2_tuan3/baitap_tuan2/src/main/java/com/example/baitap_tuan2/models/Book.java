package com.example.baitap_tuan2.models;


public class Book {
    String title;
    String author;
    String id;
    double price;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    // constructor
    public Book(String title, String author, String id, double price) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.price = price;
    }
    // toString
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", id=" + id + ", price=" + price + "]";
    }
}
