package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ClienteDTO;
import com.trabalhofinal.trabalho.entity.Cliente;
import com.trabalhofinal.trabalho.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
	
	public List <ClienteDTO> getAll(){
		List<Cliente> lista = clienteRepository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<>();
		for(Cliente cliente : lista) {
			ClienteDTO clienteDTO = toDTO(cliente);
			
			listaDTO.add(clienteDTO);
		}
		
		return listaDTO;
	}
	
	public ClienteDTO getById(int id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		if (cliente != null) {
			return toDTO(cliente);
		} else {
			return null;
		}
	}
	
	public ClienteDTO save(ClienteDTO clienteDTO) {
		Cliente cliente = toEntidade(clienteDTO);
		Cliente novoCliente = clienteRepository.save(cliente);
		
		ClienteDTO clienteAtualizado = toDTO(novoCliente);
		
		return clienteAtualizado;
	}
	
	public ClienteDTO update(ClienteDTO clienteDTO,Integer id) {
		
		Cliente clienteExistenteNoBanco = clienteRepository.findById(id).get();
		ClienteDTO clienteAtualizadoDTO = new ClienteDTO();
		if(clienteExistenteNoBanco != null) {
			clienteDTO.setNomeCompleto(clienteAtualizadoDTO.getNomeCompleto());
			clienteDTO.setPedido(clienteAtualizadoDTO.getPedido());
			clienteDTO.setEmail(clienteAtualizadoDTO.getEmail());
			clienteDTO.setEndereco(clienteAtualizadoDTO.getEndereco());
			
			clienteExistenteNoBanco = toEntidade(clienteDTO);
			
			Cliente clienteAtualizado = clienteRepository.save(clienteExistenteNoBanco);
			
			clienteAtualizadoDTO = toDTO(clienteAtualizado);
		}
		
		return clienteAtualizadoDTO;
	}
	
	public ClienteDTO delete(Integer id) {
		clienteRepository.deleteById(id);
		
		return getById(id);
	}
	
	public ClienteDTO toDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		
		clienteDTO.setCpf(cliente.getCpf());;
		clienteDTO.setNomeCompleto(cliente.getNomeCompleto());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());
		clienteDTO.setTelefone(cliente.getTelefone());
		//clienteDTO.setPedido(cliente.getPedido());
		
		return clienteDTO;
	}
	
	public Cliente toEntidade(ClienteDTO clienteDTO) {
		 Cliente cliente = new Cliente();
		 
		 cliente.setCpf(clienteDTO.getCpf());;
			cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
			cliente.setDataNascimento(clienteDTO.getDataNascimento());
			cliente.setTelefone(clienteDTO.getTelefone());
			//cliente.setPedido(clienteDTO.getPedido());
			
			return cliente;
	}
}
