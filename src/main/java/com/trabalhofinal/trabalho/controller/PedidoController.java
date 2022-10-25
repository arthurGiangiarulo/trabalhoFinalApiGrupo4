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

import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.dto.RelatorioPedido;
//import com.trabalhofinal.trabalho.service.EmailService;
import com.trabalhofinal.trabalho.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
//	@Autowired
//	EmailService emailService;
	

//CONTROLLER DOS DTO's
	@GetMapping("/search")
	public ResponseEntity<List<PedidoDTO>> getAll() {
		return new ResponseEntity<>(pedidoService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/search/id/{id}")
	public ResponseEntity<PedidoDTO> getById(@PathVariable int id) {
		PedidoDTO pedidoDTO = pedidoService.getById(id);
		if (pedidoDTO != null) {
			return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pedidoDTO, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<PedidoDTO> save(@RequestBody PedidoDTO pedidoDTO) {
//		emailService.sendMail("arthurcg@live.com", "Teste API", "Body");
		return new ResponseEntity<>(pedidoService.save(pedidoDTO), HttpStatus.CREATED);
	}

	@GetMapping("/search/pedidoitem")
	public ResponseEntity<List<RelatorioPedido>> getAllPedidoItem() {
		return new ResponseEntity<>(pedidoService.getAllPedidoItem(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PedidoDTO> updateEditoraDTO(@RequestBody PedidoDTO pedidoDTO, @PathVariable Integer id) {
		return new ResponseEntity<>(pedidoService.update(pedidoDTO, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PedidoDTO> deletePedidoDTO(int id) {
		PedidoDTO pedidoDTO = pedidoService.getById(id);
		if (pedidoDTO == null) {
			return new ResponseEntity<>(pedidoDTO, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(pedidoService.delete(id), HttpStatus.OK);
		}
	}
}
