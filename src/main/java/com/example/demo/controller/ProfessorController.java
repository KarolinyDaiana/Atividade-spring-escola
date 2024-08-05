package com.example.demo.controller;

import com.example.demo.controller.dto.ProfessorDto;
import com.example.demo.entity.Professor;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;
    ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@RequestBody ProfessorDto professorDto) {
        return ResponseEntity.ok(professorService.criarProfessor(professorDto));
        //return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoes(), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessor() {
        return ResponseEntity.ok(professorService.verProfessores());
    }

}
