package com.example.demo.controller.dto;

import com.example.demo.entity.Endereco;

public record AlunoDto(String nome, String email, String telefone, Endereco endereco) {
}
