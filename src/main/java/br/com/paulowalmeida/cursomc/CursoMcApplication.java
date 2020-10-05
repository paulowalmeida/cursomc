package br.com.paulowalmeida.cursomc;

import java.util.Arrays;

import br.com.paulowalmeida.cursomc.domains.City;
import br.com.paulowalmeida.cursomc.domains.State;
import br.com.paulowalmeida.cursomc.repositories.CityRepository;
import br.com.paulowalmeida.cursomc.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.paulowalmeida.cursomc.domains.Category;
import br.com.paulowalmeida.cursomc.domains.Product;
import br.com.paulowalmeida.cursomc.repositories.CategoryRepository;
import br.com.paulowalmeida.cursomc.repositories.ProductRepository;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		Category cat3 = new Category(null, "Cama, mesa e banho");
		
		Product p1 = new Product(null, "Computador", 2.000);
		Product p2 = new Product(null, "Poltrona Presidente", 500.0);
		Product p3 = new Product(null, "Cama", 1.500);

		cat1.getProducts().add(p1);
		cat2.getProducts().add(p2);
		cat3.getProducts().add(p3);

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat3);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State st1 = new State(null, "Pará", "PA", "Norte");
		State st2 = new State(null, "Amazonas", "AM", "Norte");
		State st3 = new State(null, "Amapá", "AP", "Norte");
		State st4 = new State(null, "Minas Gerais", "MG", "Sudeste");
		State st5 = new State(null, "São Paulo", "SP", "Sudeste");

		City ct1 = new City(null, "Ananindeua", st1);
		City ct2 = new City(null, "Manaus", st2);
		City ct3 = new City(null, "Macapá", st3);
		City ct4 = new City(null, "Santa Rita do Sapucaí", st4);
		City ct5 = new City(null, "Guarulhos", st5);

		st1.getCities().add(ct1);
		st2.getCities().add(ct2);
		st3.getCities().add(ct3);
		st4.getCities().add(ct4);
		st5.getCities().add(ct5);

		stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4, st5));
		cityRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4, ct5));
	}
}
