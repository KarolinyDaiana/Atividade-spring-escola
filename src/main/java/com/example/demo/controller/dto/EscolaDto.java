package com.example.demo.controller.dto;

import com.example.demo.entity.Curso;
import com.example.demo.entity.Endereco;

import java.util.List;

public record EscolaDto(String nome, Endereco endereco, String email, List<Curso> cursos) {

}
