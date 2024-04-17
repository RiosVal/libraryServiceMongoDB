package com.example.libraryServiceMongoDB.service;

import com.example.libraryServiceMongoDB.model.Book;
import org.springframework.http.HttpHeaders;

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
    public HttpHeaders getHeaders(String id);

    // OPTIONS

}
