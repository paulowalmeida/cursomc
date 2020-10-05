package br.com.paulowalmeida.cursomc.repositories;

import br.com.paulowalmeida.cursomc.domains.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
