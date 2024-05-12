package com.itvedant.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.gamestore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
