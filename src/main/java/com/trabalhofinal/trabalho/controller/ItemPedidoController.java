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

import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.service.ItemPedidoService;

@RestController
@RequestMapping("/itensPedido")
public class ItemPedidoController {
	@Autowired
	ItemPedidoService itemService;

//CONTROLLER DOS DTO's
	@GetMapping("/search")
	public ResponseEntity<List<ItemPedidoDTO>> getAll() {
		return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/search/id/{id}")
	public ResponseEntity<ItemPedidoDTO> getById(@PathVariable int id) {
		ItemPedidoDTO itemDTO = itemService.getById(id);
		if (itemDTO != null) {
			return new ResponseEntity<>(itemDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(itemDTO, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<ItemPedidoDTO> save(@RequestBody ItemPedidoDTO itemDTO) {
		return new ResponseEntity<>(itemService.save(itemDTO), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<ItemPedidoDTO> updateEditoraDTO(@RequestBody ItemPedidoDTO itemDTO,
			@PathVariable Integer id) {
		return new ResponseEntity<>(itemService.update(itemDTO, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ItemPedidoDTO> deleteItemDTO(int id) {
		ItemPedidoDTO itemDTO = itemService.getById(id);
		if (itemDTO == null) {
			return new ResponseEntity<>(itemDTO, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(itemService.delete(id), HttpStatus.OK);
		}
	}
}
