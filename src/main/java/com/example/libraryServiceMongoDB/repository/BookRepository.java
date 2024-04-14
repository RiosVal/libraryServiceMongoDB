package com.example.libraryServiceMongoDB.repository;

import com.example.libraryServiceMongoDB.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    Book findBookById(String id);
}
