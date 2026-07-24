package com.estudojava.projeto_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudojava.projeto_spring_boot.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
