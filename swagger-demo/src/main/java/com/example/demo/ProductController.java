package com.example.demo;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Iterable list(Model model) {
		Iterable productList = new ArrayList<String>();
		return productList;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public Product showProduct(@PathVariable Integer id, Model model) {
		Product product = new Product();
		product.setId(id);
		return product;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity saveProduct(@RequestBody Product product) {
		return new ResponseEntity("Product saved successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		return new ResponseEntity("Product updated successfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable Integer id) {
		return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
	}
}