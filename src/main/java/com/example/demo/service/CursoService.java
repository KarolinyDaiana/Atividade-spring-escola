package com.example.demo.service;

import com.example.demo.controller.dto.CursoDto;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Disciplina;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.DisciplinaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CursoService {
    CursoRepository cursoRepository;
    DisciplinaRepository disciplinaRepository;

    public Curso criarCurso(CursoDto cursoDto) {
        cursoDto.listaDeDisciplinas().stream().forEach(disciplina -> disciplinaRepository.findById(disciplina.getId()));
        Curso curso = new Curso(cursoDto.nome(), cursoDto.listaDeDisciplinas());

        return cursoRepository.save(curso);
    }

    public Curso verCurso(Long id) {
        return cursoRepository.findById(id).get();
    }

    public List<Curso> verCursos() {
        return cursoRepository.findAll();
    }

    public Curso atualizarCurso(Long id, CursoDto cursoDto) {
        Curso curso = verCurso(id);
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    public String excluirCurso(Long id) {
        cursoRepository.deleteById(id);
        return "Curso excluído com sucesso!";
    }
}
