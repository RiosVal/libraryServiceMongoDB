package com.example.libraryServiceMongoDB.controller;

import com.example.libraryServiceMongoDB.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.libraryServiceMongoDB.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/findAll")
    public ResponseEntity<List<Book>> findAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @PostMapping("/saveNewBook")
    public ResponseEntity<Book> saveNewBook(@RequestBody Book book){
        Book bookDB = bookService.saveBook(book);
        return ResponseEntity.ok(bookDB);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id){
        return ResponseEntity.ok(bookService.deleteBook(id));
    }

    @PatchMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @PutMapping("/updateStock")
    public ResponseEntity<Book> updateStock(@RequestBody Book book){
        return ResponseEntity.ok(bookService.updateStock(book));
    }

    @RequestMapping(value = "/headersBook/{id}")
    public ResponseEntity<Void> headBook(@PathVariable String id){
        return new ResponseEntity<>(bookService.getHeaders(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/options")
    public ResponseEntity<?> options(){
        return ResponseEntity.ok().allow(
                HttpMethod.GET,
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE
        ).build();
    }
}
