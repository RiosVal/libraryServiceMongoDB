package com.example.libraryServiceMongoDB.service;

import com.example.libraryServiceMongoDB.model.Book;

import java.util.List;

public interface BookService {

    // GET
    public List<Book> findAllBooks();

    // POST
    public Book saveBook(Book book);

    // DELETE
    public boolean deleteBook(String idBook);

    // PATCH
    public Book updateBook(Book book);

    // PUT
    public Book updateStock(Book book);

    // HEAD
    public Object getHeaders(String id);

    // OPTIONS

}
