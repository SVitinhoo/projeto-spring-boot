package com.estudojava.projeto_spring_boot.services;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudojava.projeto_spring_boot.entities.Order;
import com.estudojava.projeto_spring_boot.repositories.OrderRepository;
import com.estudojava.projeto_spring_boot.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	private final OrderRepository repository;

	OrderService(OrderRepository repository) {
		this.repository = repository;
	}
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
