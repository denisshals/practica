package com.example.practica.controller;
import com.example.practica.entity.Book;
import com.example.practica.entity.PublishingHouse;
import com.example.practica.service.BookService;
import com.example.practica.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    PublishingHouseService publishingHouseService;
    @GetMapping("/book")
    public String book(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book";
    }
    @GetMapping("/newBookForm")
    public String showNewBookForm(Model model) {
        List<PublishingHouse> publishingHouseList = publishingHouseService.getAllPublishingHouses();
        if(publishingHouseList.isEmpty()) return "redirect:/book";
        Book book = new Book();
        model.addAttribute("book", book);
        model.addAttribute("publishingHouseList", publishingHouseList);
        return "new_book";
    }
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        if(book.getPublishingHouse() == null) return "redirect:/book";
        bookService.saveBook(book);
        return "redirect:/book";
    }
    @GetMapping("/showFormForBookUpdate/{id}")
    public String showFormForBookUpdate(@PathVariable(value = "id") int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("publishingHouseList", publishingHouseService.getAllPublishingHouses());
        return "update_book";
    }
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable(value = "id") int id){
        System.out.println(id);
        bookService.deleteBookById(id);
        return "redirect:/book";
    }
}