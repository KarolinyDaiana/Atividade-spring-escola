package com.example.demo.service;

import com.example.demo.controller.dto.EnderecoDto;
import com.example.demo.entity.Endereco;
import com.example.demo.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public String criarEndereco(EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco(enderecoDto.rua(), enderecoDto.bairro(), enderecoDto.cidade(), enderecoDto.estado(), enderecoDto.numero(), enderecoDto.cep());
        enderecoRepository.save(endereco);
        return "Endereço criado com sucesso!";
    }

    public Endereco verEndereco(Long id) {
        return enderecoRepository.findById(id).get();
    }
    public List<Endereco> verEnderecos() {
        return enderecoRepository.findAll();
    }
    public Endereco atualizarEndereco(Long id, EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco(enderecoDto.rua(), enderecoDto.bairro(), enderecoDto.cidade(), enderecoDto.estado(), enderecoDto.numero(), enderecoDto.cep());
        endereco.setId(id);
        return enderecoRepository.save(endereco);
    }
    public String excluirEndereco(Long id) {
        enderecoRepository.deleteById(id);
        return "Endereço excluído com sucesso!";
    }


}

