package com.trabalhofinal.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.entity.Endereco;
import com.trabalhofinal.trabalho.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEnderecos(){
        return enderecoRepository.findAll();
        //incluir tratamento/verificação para not found?
    }

    public Endereco getEnderecoById(Integer id){
        return enderecoRepository.findById(id).orElse(null);
        //incluir tratamento/verificação para not found?
    }

    public Endereco saveEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }
    
    public Endereco uptadeEndereco(Endereco endereco, Integer id){
        Endereco enderecoExistenteNoBanco = getEnderecoById(id);
        enderecoExistenteNoBanco.setAllAtributos(endereco);
        return enderecoRepository.save(enderecoExistenteNoBanco);
    }

    public Endereco deleteEndereco(Integer id){
        enderecoRepository.deleteById(id);
        return getEnderecoById(id);
    }
    
    // public Endereco deleteEndereco(Integer id){
    //     Endereco endereco = getEnderecoById(id);
        
    //     //Incluir tratamento para id not found
    //     if(endereco != null){
    //         enderecoRepository.deleteById(id);
    //         return endereco;
    //     } else {
    //         return endereco;
    //     }
    // }
}
