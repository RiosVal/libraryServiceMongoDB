package com.example.libraryServiceMongoDB.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("books")
public class Book {
    @Id
    private String id;
    private String title;
    private String genre;
    private String author;
    private Integer stock;

    public Book() {}

    public Book(String id, String title, String genre, String author, Integer stock) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{ " +
                "id='" + id + '\''+
                "title='" + title + '\''+
                "genre='" + genre + '\''+
                "stock='" + stock + '\''+
                "}" + "\n";
    }
}
