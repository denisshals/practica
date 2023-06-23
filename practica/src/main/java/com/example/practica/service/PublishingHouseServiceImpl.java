package com.example.practica.service;
import com.example.practica.entity.PublishingHouse;
import com.example.practica.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PublishingHouseServiceImpl implements PublishingHouseService{
    @Autowired
    PublishingHouseRepository publishingHouseRepository;
    @Override
    public List<PublishingHouse> getAllPublishingHouses() {
        return publishingHouseRepository.findAll();
    }
    @Override
    public void savePublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouseRepository.save(publishingHouse);
    }
    @Override
    public PublishingHouse getPublishingHouseById(int id) {
        Optional<PublishingHouse> optional = publishingHouseRepository.findById(id);
        PublishingHouse publishingHouse = null;
        if(optional.isPresent()) publishingHouse = optional.get();
        else throw new RuntimeException(" Publishing house not found for id: " + id);
        return publishingHouse;
    }
    @Override
    public PublishingHouse getPublishingHouseByName(String name) {
        return this.publishingHouseRepository.findByName(name);
    }
    @Override
    public void deletePublishingHouseById(int id) {
        this.publishingHouseRepository.deleteById(id);
    }
}
