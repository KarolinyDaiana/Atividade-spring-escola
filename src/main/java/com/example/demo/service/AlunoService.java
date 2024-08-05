package com.example.demo.service;

import com.example.demo.controller.dto.AlunoDto;
import com.example.demo.entity.Aluno;
import com.example.demo.entity.Endereco;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
    private EnderecoRepository enderecoRepository;

    public Aluno criarAluno(AlunoDto alunoDto) {
        Endereco endereco = enderecoRepository.findById(alunoDto.endereco().getId()).get();
        Aluno aluno = new Aluno(alunoDto.nome(), alunoDto.email(), alunoDto.telefone(), endereco);
        return alunoRepository.save(aluno);
    }

    public Aluno verAluno(Long id) {
        return alunoRepository.findById(id).get();
    }

    public List<Aluno> verAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno atualizarAluno(Long id, AlunoDto alunoDto) {
        Endereco endereco = enderecoRepository.findById(alunoDto.endereco().getId()).get();
        Aluno aluno = new Aluno(alunoDto.nome(), alunoDto.email(), alunoDto.telefone(), endereco);
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public String excluirAluno(Long id) {
        alunoRepository.deleteById(id);
        return "Aluno excluído com sucesso!";
    }

}
