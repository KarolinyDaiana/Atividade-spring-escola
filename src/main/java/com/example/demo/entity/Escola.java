package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @OneToOne
    private Endereco endereco;

    @Column
    private String email;

    @OneToMany(mappedBy = "escola")
    private List<Professor> listaDeProfessores;

    @OneToMany
    @JoinColumn(name = "escola")
    private List<Curso> listaDeCursos;

    public Escola(String nome, Endereco endereco, String email, List<Curso> cursos) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.listaDeCursos = cursos;
    }
}
