package br.com.paulowalmeida.cursomc.services;

import br.com.paulowalmeida.cursomc.domains.Product;
import br.com.paulowalmeida.cursomc.repositories.ProductRepository;
import br.com.paulowalmeida.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> productResult = this.repository.findById(id);
        return productResult.orElseThrow(() -> new ObjectNotFoundException(
                ObjectNotFoundException.getMessageFormatted(id, Product.class.getSimpleName()))
        );
    }
}
