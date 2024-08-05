package com.example.demo.controller;

import com.example.demo.controller.dto.CursoDto;
import com.example.demo.entity.Curso;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/curso")
public class CursoController {

    CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody CursoDto cursoDto) {
        return ResponseEntity.ok(cursoService.criarCurso(cursoDto));
    }
    @GetMapping
    public ResponseEntity<List<Curso>> verCursos() {
        return ResponseEntity.ok(cursoService.verCursos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Curso> verCurso(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.verCurso(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody CursoDto cursoDto) {
        return ResponseEntity.ok(cursoService.atualizarCurso(id, cursoDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCurso(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.excluirCurso(id));
    }
}
