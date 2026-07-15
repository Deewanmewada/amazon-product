package com.amazon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.AmazonEntity;
import com.amazon.repository.AmazonRepository;
import com.amazon.request.AmazonRequest;

@Service
public class AmazonService {
	
	@Autowired
	AmazonRepository repository;
	
	//save product
	public String saveProduct(AmazonRequest request) {
		
		AmazonEntity entity = new AmazonEntity();
		
		entity.setProductName(request.getProductName());
		entity.setQty(request.getQty());
		entity.setPrice(request.getPrice());
		
		repository.save(entity);
		
		return "Prouduct save Successfully" ;
	}
	
	//view all
	public List<AmazonEntity> viewAllProduct(){
		
		List<AmazonEntity> products = repository.findAll();
		
		return products;
		
	}
	
	//update
	public String updateProduct(int id, AmazonRequest request) {
		
		Optional<AmazonEntity> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			AmazonEntity entity = optional.get();
			
			entity.setProductName(request.getProductName());
			entity.setQty(request.getQty());
			entity.setPrice(request.getPrice());
			
			AmazonEntity response = repository.save(entity);
			return "Updated Successfully ID: " + response.getId();
			
		}
		
		return " NOT found" ;
	}
	
	//delete
	public String deleteProduct(int id) {
		
		Optional<AmazonEntity> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			AmazonEntity entity = optional.get();
			
			repository.delete(entity);
			
			return "Deleted Successfully " ;
		}
		return "Not Found " ;
	}
	
	
}
