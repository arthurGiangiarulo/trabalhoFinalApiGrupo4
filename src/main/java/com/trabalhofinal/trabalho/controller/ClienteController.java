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

import com.trabalhofinal.trabalho.entity.Cliente;
import com.trabalhofinal.trabalho.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
	//get all
	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClientes(){
		return new ResponseEntity <>(clienteService.getAllClientes(),HttpStatus.OK); 
	}
	
	//get id
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
		Cliente cliente = clienteService.getClienteById(id);
		if(null != cliente)
		return new ResponseEntity <>(cliente,HttpStatus.OK); 
		else
			return new ResponseEntity <>(cliente,HttpStatus.NOT_FOUND);
	}
	
	//save
	@PostMapping
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
		
		return new ResponseEntity <>(clienteService.saveCliente(cliente),HttpStatus.CREATED);
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @PathVariable int id){
		return new ResponseEntity <>(clienteService.updateCliente(cliente, id),HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable int id) {
		Cliente cliente = clienteService.getClienteById(id);
		if(null == cliente)
			return new ResponseEntity <>(cliente,HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity <>(clienteService.deleteCliente(id),HttpStatus.OK);
	}
}
