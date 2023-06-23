package com.example.practica.service;
import com.example.practica.entity.BookShop;
import java.util.List;
public interface BookShopService {
    List<BookShop> getAllBookShops();
    void saveBookShop(BookShop bookShop);
    BookShop getBookShopById(int id);
    void deleteBookShopById(int id);
}
