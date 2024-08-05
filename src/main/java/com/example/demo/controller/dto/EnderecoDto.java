package com.example.demo.controller.dto;

public record EnderecoDto(String rua, Integer numero, String cidade, String estado, String bairro, Long cep) {
//rua": "Rua Dez",
//    "numero": 123,
//    "cidade": "Santa Catarina",
//    "estado": "SC",
//    "bairro": "Centenário",
//    "cep": 11111111
}
