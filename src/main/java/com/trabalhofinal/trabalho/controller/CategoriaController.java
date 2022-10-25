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

import com.trabalhofinal.trabalho.dto.CategoriaDTO;

import com.trabalhofinal.trabalho.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;

	// CONTROLLER DOS DTO's
	@GetMapping("/search")
	public ResponseEntity<List<CategoriaDTO>> getAll() {
		return new ResponseEntity<>(categoriaService.getAll(), HttpStatus.OK);
	}

	@GetMapping("search/id/{id}")
	public ResponseEntity<CategoriaDTO> getCategoriaDTOById(@PathVariable int id) {
		CategoriaDTO categoriaDTO = categoriaService.getById(id);
		if (categoriaDTO != null) {
			return new ResponseEntity<>(categoriaDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(categoriaDTO, HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<CategoriaDTO> saveCategoriaDTO(@RequestBody CategoriaDTO categoriaDTO) {
		return new ResponseEntity<>(categoriaService.save(categoriaDTO), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CategoriaDTO> updateCategoriaDTO(@RequestBody CategoriaDTO categoriaDTO,
			@PathVariable Integer id) {
		return new ResponseEntity<>(categoriaService.update(categoriaDTO, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CategoriaDTO> deleteCategoriaDTO(@PathVariable Integer id) {
		CategoriaDTO categoriaDTO = categoriaService.getById(id);
		if (categoriaDTO == null) {
			return new ResponseEntity<>(categoriaDTO, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(categoriaService.delete(id), HttpStatus.OK);
		}
	}
}