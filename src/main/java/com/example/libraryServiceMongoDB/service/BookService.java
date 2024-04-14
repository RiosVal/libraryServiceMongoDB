package com.example.libraryServiceMongoDB.service;

import com.example.libraryServiceMongoDB.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.libraryServiceMongoDB.repository.BookRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    //private List<Book> booksList;

    boolean started = false;
    public void setBooks(){
        if(this.started == false) {
            bookRepository.save(new Book("GGM1", "Cien años de soledad", "Realismo mágico", "Gabriel García Márquez", 25));
            bookRepository.save(new Book("GO1", "1984", "Distopía", "George Orwell", 15));
            bookRepository.save(new Book("DB1", "El código Da Vinci", "Thriller", "Dan Brown", 30));
            bookRepository.save(new Book("JA1", "Orgullo y prejuicio", "Novela romántica", "Jane Austen", 20));
            bookRepository.save(new Book("PC1", "El alquimista", "Ficción", "Paulo Coelho", 18));
            this.started = true;
        }
    }

    public String getAll(){
        //setBooks();
        return "--EXISTING BOOKS--\n"+ bookRepository.findAll();
    }

    public String insert(Book book){
        //setBooks();
        bookRepository.save(new Book(book.getId(), book.getTitle(), book.getGenre(), book.getAuthor(), book.getStock()));
        return "--BOOK INSERTED--" + book.toString();
    }

    public String update(Book book){
        //setBooks();
        List<Book> booksList = bookRepository.findAll();
        Iterator<Book> iterator = booksList.iterator();
        while (iterator.hasNext()){
            Book bookIterator = iterator.next();
            if (bookIterator.getId().equals(book.getId())){
                bookIterator.setTitle(book.getTitle());
                bookIterator.setGenre(book.getGenre());
                bookIterator.setAuthor(book.getAuthor());
                bookIterator.setStock(book.getStock());
                return "--BOOK UPDATED--\n" + bookIterator.toString();
            }
        }
        return "--BOOK NOT FOUND--";
    }

    public String delete(String id) {
        //setBooks();
        List<Book> booksList = bookRepository.findAll();
        Iterator<Book> iterator = booksList.iterator();
        while (iterator.hasNext()) {
            Book bookIterator = iterator.next();
            if (bookIterator.getId().equals(id)) {
                iterator.remove();
                return "---BOOK DELETED---";
            }
        }
        return "---BOOK NOT FOUND---";
    }

    public String updateData(String id, Book requestBook){
        Book book = bookRepository.findBookById(id);
        System.out.println(requestBook.toString());

        if (book != null) {
            if (book.getTitle() != null) {
                book.setTitle(requestBook.getTitle());
            }
            if (book.getGenre() != null) {
                book.setGenre(requestBook.getGenre());
            }
            if (book.getAuthor() != null) {
                book.setAuthor(requestBook.getAuthor());
            }
            if (book.getStock() != null) {
                book.setStock(requestBook.getStock());
            }
            return "---BOOK UPDATED---\n" + book.toString();
        } else {
            return "---BOOK NOT FOUND---";
        }

        /*List<Book> booksList = bookRepository.findAll();
        Iterator<Book> iterator = booksList.iterator();
        while(iterator.hasNext()) {
            Book bookIterator = iterator.next();
            if (bookIterator.getId().equals(id)) {
                if (book.getTitle() != null) {
                    bookIterator.setTitle(book.getTitle());
                }
                if (book.getGenre() != null) {
                    bookIterator.setGenre(book.getGenre());
                }
                if (book.getAuthor() != null) {
                    bookIterator.setAuthor(book.getAuthor());
                }
                if (book.getStock() != null) {
                    bookIterator.setStock(book.getStock());
                }
                return "---BOOK UPDATED---\n"+bookIterator.toString();
            }
        }
        return "---BOOK NOT FOUND---";*/
    }

    public String optionsUpdate(){
        return "OPTIONS: It inserts a new book, if the book doesn't exist, it will create one automatically";
    }
}
