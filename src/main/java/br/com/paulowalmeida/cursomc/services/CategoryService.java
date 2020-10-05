package br.com.paulowalmeida.cursomc.services;

import br.com.paulowalmeida.cursomc.domains.Category;
import br.com.paulowalmeida.cursomc.repositories.CategoryRepository;
import br.com.paulowalmeida.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return this.repository.findAll();
    }

    public Category findById(long id) {
        Optional<Category> categoryResult = this.repository.findById(id);
        return categoryResult.orElseThrow(() -> new ObjectNotFoundException(
                ObjectNotFoundException.getMessageFormatted(id, Category.class.getSimpleName()))
        );
    }

}
