package com.example.practica.repository;
import com.example.practica.entity.BookShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookShopRepository extends JpaRepository<BookShop, Integer> {
}
