package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany
    private List<Disciplina> listaDeDisciplinas;

    public Curso(String nome, List<Disciplina> listaDeDisciplinas) {
        this.nome = nome;
        this.listaDeDisciplinas = listaDeDisciplinas;
    }
}
