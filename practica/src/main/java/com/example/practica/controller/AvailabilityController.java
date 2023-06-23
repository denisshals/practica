package com.example.practica.controller;
import com.example.practica.entity.Book;
import com.example.practica.entity.BookShop;
import com.example.practica.service.BookService;
import com.example.practica.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class AvailabilityController {
    @Autowired
    BookShopService bookShopService;
    @Autowired
    BookService bookService;
    @GetMapping("/availability/{id}")
    public String addBookToBookShop(@PathVariable(value = "id") int id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        List<BookShop> includedBookShop = book.getBookShops();
        List<BookShop> notIncludedBookShop = bookShopService.getAllBookShops();
        notIncludedBookShop.removeAll(includedBookShop);
        model.addAttribute("includedBookShopList", includedBookShop);
        model.addAttribute("notIncludedBookShopList", notIncludedBookShop);
        return "availability";
    }
    @PostMapping("/saveAvailability/{id}")
    public String saveAvailability(@PathVariable(value = "id") int bookId, @RequestParam(value = "bookShopId") int bookShopId) {
        if(bookShopId == -1) return "redirect:/availability/" + bookId;
        Book book = bookService.getBookById(bookId);
        List<BookShop> bookShopList = book.getBookShops();
        bookShopList.add(bookShopService.getBookShopById(bookShopId));
        book.setBookShops(bookShopList);
        bookService.saveBook(book);
        return "redirect:/availability/" + bookId;
    }
    @GetMapping("/deleteAvailability/{id1}/{id2}")
    public String deleteBook(@PathVariable(value = "id1") int book_id, @PathVariable(value = "id2") int bookShop_id){
        Book book = bookService.getBookById(book_id);
        book.getBookShops().remove(bookShopService.getBookShopById(bookShop_id));
        bookService.saveBook(book);
        return "redirect:/availability/" + book_id;
    }
}
