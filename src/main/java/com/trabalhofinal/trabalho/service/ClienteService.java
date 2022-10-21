package com.trabalhofinal.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.entity.Cliente;
import com.trabalhofinal.trabalho.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
        //incluir tratamento/verificação para not found?
    }

    public Cliente getClienteById(Integer id){
        return clienteRepository.findById(id).orElse(null);
        //incluir tratamento/verificação para not found?
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public Cliente uptadeCliente(Cliente cliente, Integer id){
        Cliente clienteExistenteNoBanco = getClienteById(id);
        clienteExistenteNoBanco.setAllAtributos(cliente);
        return clienteRepository.save(clienteExistenteNoBanco);
    }

    public Cliente deleteCliente(Integer id){
        clienteRepository.deleteById(id);
        return getClienteById(id);
    }

}
