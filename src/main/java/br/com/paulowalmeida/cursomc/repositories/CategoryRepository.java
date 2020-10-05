package br.com.paulowalmeida.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paulowalmeida.cursomc.domains.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
