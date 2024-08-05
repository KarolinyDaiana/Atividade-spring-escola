package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column
    private String telefone;

    @ManyToOne
    @JsonIgnore
    private Escola escola;

    @ManyToMany(mappedBy = "listaDeProfessores")
    private List<Disciplina> listaDeDisciplinas;

    @OneToOne
    private Endereco endereco;

    public Professor(String nome, String email, String telefone, Escola escola, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.escola = escola;
        this.endereco = endereco;
    }
}
