package br.com.paulowalmeida.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulowalmeida.cursomc.domains.Category;
import br.com.paulowalmeida.cursomc.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok().body(this.categoryService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id) {
		Category categoryResult = this.categoryService.findById(id);
		return ResponseEntity.ok().body(categoryResult);
	}
}
