package com.example.demo.service;

import com.example.demo.controller.dto.ProfessorDto;
import com.example.demo.entity.Endereco;
import com.example.demo.entity.Escola;
import com.example.demo.entity.Professor;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.EscolaRepository;
import com.example.demo.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {

    ProfessorRepository professorRepository;
    EscolaRepository escolaRepository;
    EnderecoRepository enderecoRepository;

    public Professor criarProfessor(ProfessorDto professorDto) {
//        String nome, String email, String telefone, Long escola, Long endereco
        Escola escola = escolaRepository.findById(professorDto.escola().getId()).get();
        Endereco endereco = enderecoRepository.findById(professorDto.endereco().getId()).get();
        Professor professor = new Professor(professorDto.nome(), professorDto.email(), professorDto.telefone(), escola, endereco);
        return professorRepository.save(professor);
    }

    public List<Professor> verProfessores() {
        return professorRepository.findAll();
    }
}
