package com.trabalhofinal.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.trabalho.dto.ClienteDTO;
import com.trabalhofinal.trabalho.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteService clienteService;

// CONTROLLER DOS DTO's
	@GetMapping("/dto")
	public ResponseEntity<List<ClienteDTO>> getAllClienteDTO() {
		return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<ClienteDTO> getClienteDTOById(@PathVariable int id) {
		ClienteDTO clienteDTO = clienteService.getById(id);
		if (clienteDTO != null) {
			return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(clienteDTO, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/dto")
	public ResponseEntity<ClienteDTO> saveClienteDTO(@RequestBody ClienteDTO clienteDTO) {
		return new ResponseEntity<>(clienteService.save(clienteDTO), HttpStatus.CREATED);
	}

	@PutMapping("/dto/{id}")
	public ResponseEntity<ClienteDTO> updateClienteDTO(@RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
		return new ResponseEntity<>(clienteService.update(clienteDTO, id), HttpStatus.OK);
	}

	@DeleteMapping("/dto/delete/{id}")
	public ResponseEntity<ClienteDTO> deleteClienteDTO(@PathVariable Integer id) {
		ClienteDTO clienteDTO = clienteService.getById(id);
		if (clienteDTO == null) {
			return new ResponseEntity<>(clienteDTO, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(clienteService.delete(id), HttpStatus.OK);
		}
	}
}
