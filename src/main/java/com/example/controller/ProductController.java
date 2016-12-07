package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
    
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
    	
    	productService.saveProduct(product);
    }
    
    @PostMapping("/searchProduct")
    public List<Product> searchProduct(@RequestBody Product searchedProduct) {
    	
    	List<Product> list = productService.searchProduct(searchedProduct.getProductName());

    	return list;

    }
    
    @GetMapping("/allProducts")
    public List<Product> allProducts() {

    	List<Product> allProducts = productService.getAllProducts();
    	
    	return allProducts;
    }

}
