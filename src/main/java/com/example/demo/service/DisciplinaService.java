package com.example.demo.service;

import com.example.demo.entity.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DisciplinaService {
    DisciplinaRepository disciplinaRepository;

    public Disciplina criarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina verDisciplina(Long id) {
        return disciplinaRepository.findById(id).get();
    }

    public List<Disciplina> verDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public String excluirDisciplina(Long id) {
        disciplinaRepository.deleteById(id);
        return "Disciplina excluída com sucesso!";
    }
}
