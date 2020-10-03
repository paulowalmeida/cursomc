package br.com.paulowalmeida.cursomc.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.paulowalmeida.cursomc.domain.Category;

@RestController
@RequestMapping("/categories")
public class CategoryResource {
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll(){
		Category cat1 = new Category(1, "Informática");
		Category cat2 = new Category(1, "Escritório");
		List<Category> categories = Arrays.asList(cat1, cat2); 
		return ResponseEntity.ok().body(categories);
	}
}
