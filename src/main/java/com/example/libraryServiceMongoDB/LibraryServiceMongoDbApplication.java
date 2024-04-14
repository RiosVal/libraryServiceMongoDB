package com.example.libraryServiceMongoDB;

import com.example.libraryServiceMongoDB.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryServiceMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceMongoDbApplication.class, args);
	}
}
