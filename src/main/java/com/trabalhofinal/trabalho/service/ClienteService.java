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
	
	//get all
	public List<Cliente> getAllClientes(){
		return clienteRepository.findAll(); 
	}
	
	//get id
	public Cliente getClienteById(int id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
	//save
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//update
	public Cliente updateCliente (Cliente cliente, int id) { 
		
		Cliente clienteExistenteNoBanco = clienteRepository.findById(id).get();
		clienteExistenteNoBanco.setNomeCompleto(cliente.getNomeCompleto());
		clienteExistenteNoBanco.setEmail(cliente.getEmail());
		clienteExistenteNoBanco.setCpf(cliente.getCpf());
		clienteExistenteNoBanco.setTelefone(cliente.getTelefone());
		clienteExistenteNoBanco.setDataNascimento(cliente.getDataNascimento());
		clienteExistenteNoBanco.setEndereco(cliente.getEndereco());
		
		return clienteRepository.save(clienteExistenteNoBanco);
	}
	
	//delete
	public Cliente deleteCliente(int id) {
		clienteRepository.deleteById(id);
		return getClienteById(id);
	}
}
