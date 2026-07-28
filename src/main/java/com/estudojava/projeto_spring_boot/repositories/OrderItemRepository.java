package com.estudojava.projeto_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudojava.projeto_spring_boot.entities.OrderItem;
import com.estudojava.projeto_spring_boot.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
