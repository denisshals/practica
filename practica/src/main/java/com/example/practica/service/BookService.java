package com.example.practica.service;
import com.example.practica.entity.Book;
import java.util.List;
public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Book getBookById(int id);
    void deleteBookById(int id);
}
