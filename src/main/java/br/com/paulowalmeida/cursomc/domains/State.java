package br.com.paulowalmeida.cursomc.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class State implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, length = 2)
    private String initials;

    @Column(nullable = false)
    private String region;

    @JsonManagedReference
    @OneToMany(mappedBy = "state")
    private List<City> cities = new ArrayList<>();

    public State(Long id, String nome, String initials, String region) {
        this.id = id;
        this.nome = nome;
        this.initials = initials;
        this.region = region;
    }

    public State() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(id, state.id) &&
                Objects.equals(nome, state.nome) &&
                Objects.equals(initials, state.initials) &&
                Objects.equals(region, state.region) &&
                Objects.equals(cities, state.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, initials, region, cities);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", initials='" + initials + '\'' +
                ", region='" + region + '\'' +
                ", cities=" + cities +
                '}';
    }
}
