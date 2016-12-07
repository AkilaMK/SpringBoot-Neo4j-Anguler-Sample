package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getAllProducts();

	List<Product> searchProduct(String productName);

}
