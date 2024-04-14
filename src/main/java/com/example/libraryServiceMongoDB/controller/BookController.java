package com.example.libraryServiceMongoDB.controller;

import com.example.libraryServiceMongoDB.model.Book;
import com.example.libraryServiceMongoDB.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    // 1. metodo de ejemplo para verbo GET
    @GetMapping("/getAll")
    public String getAll(){
        return bookService.getAll();
    }

    // 2. metodo de ejemplo para verbo POST
    @PostMapping("/insert")
    public String insert(@RequestBody Book book){
        return bookService.insert(book);
    }

    // 3. metodo de ejemplo para verbo UPDATE
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        return bookService.update(book);
    }

    // 4. metodo de ejemplo para verbo DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") String id) {
        return bookService.delete(id);
    }

    // 5. metodo de ejemplo para verbo PATH
    @PatchMapping("/updateData/{id}")
    public String updateData(@PathVariable String id, @RequestBody Book book){
        return bookService.updateData(id, book);
    }

    // 6. metodo de ejemplo para verbo HEAD
    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    // 7. metodo de ejemplo para verbo OPTIONS
    @RequestMapping(value = "/update", method = RequestMethod.OPTIONS)
    public String optionsUpdate() {
        return bookService.optionsUpdate();
    }
}
