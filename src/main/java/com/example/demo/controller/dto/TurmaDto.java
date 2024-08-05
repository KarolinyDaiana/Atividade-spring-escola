package com.example.demo.controller.dto;

import java.util.List;

public record TurmaDto(String nome, Long escola, List<Long> listaDeAlunos) {
}
