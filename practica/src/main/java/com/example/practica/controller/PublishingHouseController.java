package com.example.practica.controller;
import com.example.practica.entity.PublishingHouse;
import com.example.practica.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class PublishingHouseController {
    @Autowired
    PublishingHouseService publishingHouseService;
    @GetMapping("/publishingHouse")
    public String publishingHouse(Model model) {
        model.addAttribute("publishingHouseList", publishingHouseService.getAllPublishingHouses());
        return "publishingHouse";
    }
    @GetMapping("/newPublishingHouseForm")
    public String showNewPublishingHouseForm(Model model) {
        PublishingHouse publishingHouse = new PublishingHouse();
        model.addAttribute("publishingHouse", publishingHouse);
        return "new_publishingHouse";
    }
    @PostMapping("/savePublishingHouse")
    public String savePublishingHouse(@ModelAttribute("publishingHouse") PublishingHouse publishingHouse) {
        publishingHouseService.savePublishingHouse(publishingHouse);
        return "redirect:/publishingHouse";
    }
    @GetMapping("/showFormForPublishingHouseUpdate/{id}")
    public String showFormForPublishingHouseUpdate(@PathVariable(value = "id") int id, Model model){
        PublishingHouse publishingHouse = publishingHouseService.getPublishingHouseById(id);
        model.addAttribute("publishingHouse", publishingHouse);
        return "update_publishingHouse";
    }
    @GetMapping("/deletePublishingHouse/{id}")
    public String deletePublishingHouse(@PathVariable(value = "id") int id){
        publishingHouseService.deletePublishingHouseById(id);
        return "redirect:/publishingHouse";
    }
}
