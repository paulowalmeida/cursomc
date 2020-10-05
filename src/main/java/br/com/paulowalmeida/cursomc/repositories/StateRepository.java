package br.com.paulowalmeida.cursomc.repositories;

import br.com.paulowalmeida.cursomc.domains.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
