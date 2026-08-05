package com.estudojava.projeto_spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estudojava.projeto_spring_boot.entities.Category;
import com.estudojava.projeto_spring_boot.repositories.CategoryRepository;
import com.estudojava.projeto_spring_boot.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	private final CategoryRepository repository;

	CategoryService(CategoryRepository repository) {
		this.repository = repository;
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj =  repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
