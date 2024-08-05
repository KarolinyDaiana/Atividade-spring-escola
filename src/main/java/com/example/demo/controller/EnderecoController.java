package com.example.demo.controller;

import com.example.demo.controller.dto.EnderecoDto;
import com.example.demo.entity.Endereco;
import com.example.demo.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<String> criarEndereco(@RequestBody EnderecoDto enderecoDto) {
        return ResponseEntity.ok(enderecoService.criarEndereco(enderecoDto));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> verEnderecos() {
        return ResponseEntity.ok(enderecoService.verEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> verEndereco(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.verEndereco(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDto enderecoDto) {
        return ResponseEntity.ok(enderecoService.atualizarEndereco(id, enderecoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEndereco(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.excluirEndereco(id));
    }
}
