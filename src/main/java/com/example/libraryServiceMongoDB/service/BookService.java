package com.example.libraryServiceMongoDB.service;

import com.example.libraryServiceMongoDB.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookService {
    private List<Book> booksList;

    boolean started = false;
    public void setBooks(){
        if(this.started == false) {
            this.booksList = new ArrayList<>();
            booksList.add(new Book("GGM1", "Cien años de soledad", "Realismo mágico", "Gabriel García Márquez", 25));
            booksList.add(new Book("GO1", "1984", "Distopía", "George Orwell", 15));
            booksList.add(new Book("DB1", "El código Da Vinci", "Thriller", "Dan Brown", 30));
            booksList.add(new Book("JA1", "Orgullo y prejuicio", "Novela romántica", "Jane Austen", 20));
            booksList.add(new Book("PC1", "El alquimista", "Ficción", "Paulo Coelho", 18));
        }
    }

    public String getAll(){
        setBooks();
        return "--EXISTING BOOKS--\n"+ booksList.toString();
    }

    public String insert(Book book){
        setBooks();
        booksList.add(new Book(book.getId(), book.getTitle(), book.getGenre(), book.getAuthor(), book.getStock()));
        return "--BOOK INSERTED--" + book.toString();
    }

    public String update(Book book){
        setBooks();
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
        setBooks();
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

    public String updateData(String id, Book book){
        setBooks();
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
        return "---BOOK NOT FOUND---";
    }

    public String optionsUpdate(){
        return "OPTIONS: It insertS a new book, if the book doesn't exist, it will create one automatically";
    }
}
