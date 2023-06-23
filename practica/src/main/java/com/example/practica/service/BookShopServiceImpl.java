package com.example.practica.service;
import com.example.practica.entity.BookShop;
import com.example.practica.repository.BookShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class BookShopServiceImpl implements BookShopService {
    @Autowired
    BookShopRepository bookShopRepository;
    @Override
    public List<BookShop> getAllBookShops() {
        return bookShopRepository.findAll();
    }
    @Override
    public void saveBookShop(BookShop bookShop) {
        this.bookShopRepository.save(bookShop);
    }
    @Override
    public BookShop getBookShopById(int id) {
        Optional<BookShop> optional = bookShopRepository.findById(id);
        BookShop bookShop = null;
        if(optional.isPresent()) bookShop = optional.get();
        else throw new RuntimeException(" Book shop not found for id: " + id);
        return bookShop;
    }
    @Override
    public void deleteBookShopById(int id) {
        this.bookShopRepository.deleteById(id);
    }
}
