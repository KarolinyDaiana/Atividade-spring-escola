package com.example.demo.controller;

import com.example.demo.entity.Disciplina;
import com.example.demo.service.DisciplinaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<Disciplina> criarDisciplina(@RequestBody String nome) {
        return ResponseEntity.ok(disciplinaService.criarDisciplina(nome));
    }
    @GetMapping
    public ResponseEntity<List<Disciplina>> verDisciplinas() {
        return ResponseEntity.ok(disciplinaService.verDisciplinas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> verDisciplina(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.verDisciplina(id));
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable Long id, @RequestBody ) {
//        return ResponseEntity.ok(disciplinaService.atualizarDisciplina(id, disciplinaDto))
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.excluirDisciplina(id));
    }

}
