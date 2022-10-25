package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ClienteDTO;
import com.trabalhofinal.trabalho.entity.Cliente;
import com.trabalhofinal.trabalho.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	public List<ClienteDTO> getAll() {
		List<Cliente> lista = clienteRepository.findAll();
		List<ClienteDTO> listaDTO = new ArrayList<>();
		for (Cliente cliente : lista) {
			ClienteDTO clienteDTO = converteEntitytoDTO(cliente);

			listaDTO.add(clienteDTO);
		}

		return listaDTO;
	}

	public ClienteDTO getById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		if (cliente != null) {
			return converteEntitytoDTO(cliente);
		} else {
			return null;
		}
	}

	public ClienteDTO save(ClienteDTO clienteDTO) {
		clienteDTO = formatToUpperDTO(clienteDTO);
		Cliente cliente = toEntidade(clienteDTO);
		Cliente novoCliente = clienteRepository.save(cliente);

		ClienteDTO clienteAtualizado = converteEntitytoDTO(novoCliente);

		return clienteAtualizado;
	}

	public ClienteDTO update(ClienteDTO clienteDTO, Integer id) {
		clienteDTO = formatToUpperDTO(clienteDTO);
		Cliente clienteExistenteNoBanco = clienteRepository.findById(id).get();
		ClienteDTO clienteAtualizadoDTO = new ClienteDTO();
		
		if (clienteExistenteNoBanco != null) {
			
			Cliente clienteExistente = toEntidade(clienteDTO);
			
			clienteExistenteNoBanco.setNomeCompleto(clienteExistente.getNomeCompleto());
			clienteExistenteNoBanco.setPedidosDoCliente(clienteExistente.getPedidosDoCliente());
			clienteExistenteNoBanco.setEmail(clienteExistente.getEmail());
			clienteExistenteNoBanco.setEndereco(clienteExistente.getEndereco());

			

			Cliente clienteAtualizado = clienteRepository.save(clienteExistenteNoBanco);
			
			clienteAtualizadoDTO = converteEntitytoDTO(clienteAtualizado);
			 
		}
		return clienteAtualizadoDTO;
	}

	public ClienteDTO delete(Integer id) {
		clienteRepository.deleteById(id);

		return getById(id);
	}
	
	private ClienteDTO converteEntitytoDTO(Cliente cliente) {
		ClienteDTO categoriaDTO = new ClienteDTO();
		categoriaDTO = (modelMapper.map(cliente, ClienteDTO.class));
		return categoriaDTO;	
	}

	public Cliente toEntidade(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(clienteDTO.getIdCliente());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNomeCompleto(clienteDTO.getNomeCompleto());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setTelefone(clienteDTO.getTelefone());
		//Não está faltando o endereço?

		return cliente;
	}
	
//	Format inputs to UpperCase
	private ClienteDTO formatToUpperDTO(ClienteDTO clienteDTO) {
		clienteDTO.setNomeCompleto(clienteDTO.getNomeCompleto().toUpperCase());
		return clienteDTO;
	}
}
