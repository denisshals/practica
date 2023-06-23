package com.example.practica.controller;
import com.example.practica.entity.BookShop;
import com.example.practica.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class BookShopController {
    @Autowired
    BookShopService bookShopService;
    @GetMapping("/bookShop")
    public String bookShop(Model model) {
        model.addAttribute("bookShopList", bookShopService.getAllBookShops());
        return "bookShop";
    }
    @GetMapping("/newBookShopForm")
    public String showNewBookShopForm(Model model) {
        BookShop bookShop = new BookShop();
        model.addAttribute("bookShop", bookShop);
        return "new_bookShop";
    }
    @PostMapping("/saveBookShop")
    public String saveBookShop(@ModelAttribute("bookShop") BookShop bookShop) {
        bookShopService.saveBookShop(bookShop);
        return "redirect:/bookShop";
    }
    @GetMapping("/showFormForBookShopUpdate/{id}")
    public String showFormForBookShopUpdate(@PathVariable(value = "id") int id, Model model){
        BookShop bookShop = bookShopService.getBookShopById(id);
        model.addAttribute("bookShop", bookShop);
        return "update_bookShop";
    }
    @GetMapping("/deleteBookShop/{id}")
    public String deleteBookShop(@PathVariable(value = "id") int id){
        bookShopService.deleteBookShopById(id);
        return "redirect:/bookShop";
    }
}
