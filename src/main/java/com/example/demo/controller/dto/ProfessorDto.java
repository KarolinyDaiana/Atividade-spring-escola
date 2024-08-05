package com.example.demo.controller.dto;

import com.example.demo.entity.Endereco;
import com.example.demo.entity.Escola;

public record ProfessorDto(String nome, String email, String telefone, Escola escola, Endereco endereco) {
}
