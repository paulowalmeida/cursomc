package br.com.paulowalmeida.cursomc.services;

import br.com.paulowalmeida.cursomc.domains.City;
import br.com.paulowalmeida.cursomc.repositories.CityRepository;
import br.com.paulowalmeida.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> findAll() {
        return this.repository.findAll();
    }

    public City findById(Long id) {
        Optional<City> cityResult = this.repository.findById(id);
        return cityResult.orElseThrow(() -> new ObjectNotFoundException(
                ObjectNotFoundException.getMessageFormatted(id, City.class.getSimpleName()))
        );
    }
}
