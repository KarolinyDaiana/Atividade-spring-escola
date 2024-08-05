package com.example.demo.controller;

import com.example.demo.controller.dto.EscolaDto;
import com.example.demo.entity.Escola;
import com.example.demo.service.EscolaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/escola")
public class EscolaController {

    EscolaService escolaService;

    @PostMapping
    public ResponseEntity<Escola> criarEscola(@RequestBody EscolaDto escolaDto) {
        return ResponseEntity.ok(escolaService.criarEscola(escolaDto));
    }
    @GetMapping
    public ResponseEntity<List<Escola>> verEscolas() {
        return ResponseEntity.ok(escolaService.verEscolas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Escola> verEscola(@PathVariable Long id) {
        return ResponseEntity.ok(escolaService.verEscola(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizarEscola(@PathVariable Long id, @RequestBody EscolaDto escolaDto) {
        return ResponseEntity.ok(escolaService.atualizarEscola(id, escolaDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEscola(@PathVariable Long id) {
        return ResponseEntity.ok(escolaService.excluirEscola(id));
    }
}
