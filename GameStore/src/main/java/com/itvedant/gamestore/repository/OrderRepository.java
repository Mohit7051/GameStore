package com.itvedant.gamestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.gamestore.entity.Orders;


@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
