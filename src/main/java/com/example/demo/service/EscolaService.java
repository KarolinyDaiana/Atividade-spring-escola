package com.example.demo.service;

import com.example.demo.controller.dto.EscolaDto;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Endereco;
import com.example.demo.entity.Escola;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.EscolaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EscolaService {

    private final CursoRepository cursoRepository;
    private EscolaRepository escolaRepository;
    private EnderecoRepository enderecoRepository;

    public Escola criarEscola(EscolaDto escolaDto){
        Endereco endereco = enderecoRepository.findById(escolaDto.endereco().getId()).get();

//        List<Curso> cursos = new ArrayList<>();
//        escolaDto.cursos().forEach(curso -> cursos.add(cursoRepository.findById(curso.getId()).get()));

        Escola escola = new Escola(escolaDto.nome(), endereco, escolaDto.email(), escolaDto.cursos());

        return escolaRepository.save(escola);
    }
    public List<Escola> verEscolas(){
        return escolaRepository.findAll();
    }
    public Escola verEscola(Long id){
        return escolaRepository.findById(id).get();
    }
    public Escola atualizarEscola(Long id, EscolaDto escolaDto){
        Escola escola = new Escola(escolaDto.nome(), escolaDto.endereco(), escolaDto.email(), escolaDto.cursos());
        escola.setId(id);
        return escolaRepository.save(escola);
    }
    public String excluirEscola(Long id){
        escolaRepository.deleteById(id);
        return "Escola excluída com sucesso!";
    }
}
