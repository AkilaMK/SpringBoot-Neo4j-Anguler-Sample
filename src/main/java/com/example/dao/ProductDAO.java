package com.example.dao;

import com.example.model.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends GraphRepository<Product>{
	//use regular expression to get the like functionality
	@Query("MATCH (n:Product) where n.productName =~ ('(?i)'+{name}+'.*') return n")
	List<Product> searchProduct(@Param("name") String name);

}
