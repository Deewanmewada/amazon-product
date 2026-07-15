package com.amazon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.AmazonEntity;
import com.amazon.request.AmazonRequest;
import com.amazon.service.AmazonService;

@RestController
@RequestMapping("amazon")

public class AmazonController {
	
	@Autowired
	AmazonService service;
	
	//save product
	@PostMapping("/save")
	public String saveProduct(@RequestBody AmazonRequest request) {
		
		return service.saveProduct(request);
		
	}
	
	//view All
	@GetMapping("viewAll")
	public List<AmazonEntity> viewAll() {
		
		return service.viewAllProduct();
	}
	
	//Update Product
	@PutMapping("update/{id}")
	public String updateProduct(@RequestBody AmazonRequest request, @PathVariable("id") int id) {
		
		return service.updateProduct(id, request);
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		return service.deleteProduct(id);
	}
}
