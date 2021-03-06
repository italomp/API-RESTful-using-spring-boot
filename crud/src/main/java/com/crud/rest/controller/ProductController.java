package com.crud.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.model.Product;
import com.crud.rest.service.ProductService;

/**
 * This class represents the product controller and contains
 * the product routes.
 * @author Italo Modesto
 */
@CrossOrigin()
@RestController
@RequestMapping("/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	/**
	 * This is the product controller constructor.
	 * @return a product controller instance.
	 */
	public ProductController() {
		
	}
	
	/**
	 * This method creates and saves a new product.
	 * @param product: It's the new product that will be saved.
	 * @return a responseEntity with the HttpSatus.
	 */
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Product product) {
		this.productService.create(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * This method gets a product by its id.
	 * @param id: It's the product id.
	 * @return a responseEntity with the product and HttpStatus.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable long id){
		Product product = this.productService.findById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	/**
	 * This method updates a product.
	 * @param product: It's a product with the new data.
	 * @return a responseEntity with the HttpStatus.
	 */
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product product) {
		this.productService.update(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * This method deletes a product by its id.
	 * @param id: It's the product id.
	 * @return a responseEntity with the HttpSatus.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		this.productService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
