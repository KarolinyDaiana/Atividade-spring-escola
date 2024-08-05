package com.example.demo.controller;

import com.example.demo.controller.dto.AlunoDto;
import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody AlunoDto aluno) {
        return ResponseEntity.ok(alunoService.criarAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> verAlunos() {
        return ResponseEntity.ok(alunoService.verAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> verAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.verAluno(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody AlunoDto aluno) {
        return ResponseEntity.ok(alunoService.atualizarAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.excluirAluno(id));
    }
}
