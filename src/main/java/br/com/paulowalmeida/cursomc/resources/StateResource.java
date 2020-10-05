package br.com.paulowalmeida.cursomc.resources;

import br.com.paulowalmeida.cursomc.domains.State;
import br.com.paulowalmeida.cursomc.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/states")
public class StateResource {

    @Autowired
    private StateService service;

    @GetMapping
    public ResponseEntity<List<State>> findAll() {
        return ResponseEntity.ok().body(this.service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<State> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(this.service.findById(id));
    }
}
