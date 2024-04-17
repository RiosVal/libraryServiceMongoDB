package com.example.libraryServiceMongoDB.service.impl;

import com.example.libraryServiceMongoDB.model.Book;
import com.example.libraryServiceMongoDB.repository.BookRepository;
import com.example.libraryServiceMongoDB.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(String idBook) {
        Optional<Book> objBook = bookRepository.findById(idBook);
        Book bookDB = new Book();

        if(objBook.isPresent()){
            bookDB = objBook.get();
            bookRepository.delete(bookDB);
            return true;
        }
        return false;
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> objBook = bookRepository.findById(book.getId());
        Book bookDB = new Book();

        if(objBook.isPresent()){
            bookDB = objBook.get();
            if(bookDB.getTitle() != null){
                bookDB.setTitle(book.getTitle());
            }
            if(bookDB.getGenre() != null){
                bookDB.setGenre(book.getGenre());
            }
            if(bookDB.getAuthor() != null){
                bookDB.setAuthor(book.getAuthor());
            }
            if(bookDB.getStock() != null){
                bookDB.setStock(book.getStock());
            }

            bookRepository.save(bookDB);
            return bookDB;
        }
        return null;
    }

    @Override
    public Book updateStock(Book book) {
        Optional<Book> objBook = bookRepository.findById(book.getId());
        Book bookDB = objBook.get();
        bookDB.setId(book.getId());
        bookDB.setTitle(bookDB.getTitle());
        bookDB.setGenre(bookDB.getGenre());
        bookDB.setAuthor(bookDB.getAuthor());
        bookDB.setStock(book.getStock());
        bookRepository.save(bookDB);
        return bookDB;
    }

    @Override
    public HttpHeaders getHeaders(String id) {
        if (bookRepository.findById(id).isPresent()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Book", "Info");
            return headers;
        } else {
            return null;
        }
    }
}
