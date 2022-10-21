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
	
		
	//// CONTROLLER DAS ENTITY --------------------------------------------------------------------------------
//		@GetMapping
//	    public ResponseEntity<List<Categoria>> getAllCategoria(){
//	        return new ResponseEntity<>(categoriaService.getAllCategoria(), HttpStatus.OK);
//	    }
	//	
//		@GetMapping("/{id}")
//		public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id) {
//			Categoria categoria = categoriaService.getCategoriaById(id);
//			if (categoria != null) {
//				return new ResponseEntity<>(categoria, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
//			}
//		}
	//	
//		@PostMapping
//		public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
//			return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.OK);
//		}
	//	
//		@PutMapping("/{id}")
//		public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable int id) {
//			return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id), HttpStatus.OK);		
//		}
	//// FIM DO CONTROLLER DAS ENITY -----------------------------------------------------------------------------------

	// CONTROLLER DOS DTO
		@GetMapping("/dto") 
	    public ResponseEntity<List<CategoriaDTO>> getAll(){
	        return new ResponseEntity<>(categoriaService.getAll(), HttpStatus.OK);
	    } 
		
		@GetMapping("/dto/{id}")
		public ResponseEntity<CategoriaDTO> getCategoriaDTOById(@PathVariable int id) {
			CategoriaDTO categoriaDTO = categoriaService.getById(id);
			if (categoriaDTO != null) {
				return new ResponseEntity<>(categoriaDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(categoriaDTO, HttpStatus.NOT_FOUND);
			}
		}
		
		@PostMapping("/dto")
	    public ResponseEntity<CategoriaDTO> saveCategoriaDTO(@RequestBody CategoriaDTO categoriaDTO) {
	        return new ResponseEntity<>(categoriaService.save(categoriaDTO), HttpStatus.CREATED);
	    }
		
		@PutMapping("/dto/{id}")
		public ResponseEntity<CategoriaDTO> updateCategoriaDTO(@RequestBody CategoriaDTO categoriaDTO,
				@PathVariable Integer id) {
			return new ResponseEntity<>(categoriaService.update(categoriaDTO, id), HttpStatus.OK);
		}
		
		@DeleteMapping("/dto/delete")
		public ResponseEntity<CategoriaDTO> deleteCategoriaDTO(int id) {
			CategoriaDTO categoriaDTO = categoriaService.getById(id);
			if (categoriaDTO == null) {
				return new ResponseEntity<>(categoriaDTO, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(categoriaService.delete(id), HttpStatus.OK);
			}
		} 
		
	}