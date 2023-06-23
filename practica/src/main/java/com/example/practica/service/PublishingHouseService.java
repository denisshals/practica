package com.example.practica.service;
import com.example.practica.entity.PublishingHouse;
import java.util.List;
public interface PublishingHouseService {
    List<PublishingHouse> getAllPublishingHouses();
    void savePublishingHouse(PublishingHouse publishingHouse);
    PublishingHouse getPublishingHouseById(int id);
    PublishingHouse getPublishingHouseByName(String name);
    void deletePublishingHouseById(int id);
}
