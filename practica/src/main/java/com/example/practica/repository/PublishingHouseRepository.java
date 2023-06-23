package com.example.practica.repository;
import com.example.practica.entity.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Integer> {
    PublishingHouse findByName(String name);
}
