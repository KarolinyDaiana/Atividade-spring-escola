package com.example.demo.controller.dto;

import com.example.demo.entity.Disciplina;

import java.util.List;

public record CursoDto(String nome, List<Disciplina> listaDeDisciplinas) {
}
