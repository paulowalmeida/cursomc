package br.com.paulowalmeida.cursomc.services;

import br.com.paulowalmeida.cursomc.domains.State;
import br.com.paulowalmeida.cursomc.repositories.StateRepository;
import br.com.paulowalmeida.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository repository;

    public List<State> findAll() {
        return this.repository.findAll();
    }

    public State findById(Long id) {
        Optional<State> stateResult = this.repository.findById(id);
        return stateResult.orElseThrow(() -> new ObjectNotFoundException(
                ObjectNotFoundException.getMessageFormatted(id, State.class.getSimpleName()))
        );
    }
}
