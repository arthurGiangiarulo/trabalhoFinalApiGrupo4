package com.trabalhofinal.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabalhofinal.trabalho.dto.ProdutoDTO;
import com.trabalhofinal.trabalho.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	
////CONTROLLER DAS ENTITY --------------------------------------------------------------------------------
//	@GetMapping
//   public ResponseEntity<List<Categoria>> getAllCategoria(){
//       return new ResponseEntity<>(categoriaService.getAllCategoria(), HttpStatus.OK);
//   }
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id) {
//		Categoria categoria = categoriaService.getCategoriaById(id);
//		if (categoria != null) {
//			return new ResponseEntity<>(categoria, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@PostMapping
//	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
//		return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.OK);
//	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable int id) {
//		return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id), HttpStatus.OK);		
//	}
////FIM DO CONTROLLER DAS ENITY -----------------------------------------------------------------------------------

//CONTROLLER DOS DTO
	@GetMapping("/dto") 
   public ResponseEntity<List<ProdutoDTO>> getAll(){
       return new ResponseEntity<>(produtoService.getAll(), HttpStatus.OK);
   } 
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<ProdutoDTO> getById(@PathVariable int id) {
		ProdutoDTO produtoDTO = produtoService.getById(id);
		if (produtoDTO != null) {
			return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(produtoDTO, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/dto")
   public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
       return new ResponseEntity<>(produtoService.save(produtoDTO), HttpStatus.CREATED);
   }
	
	@PutMapping("/dto/{id}")
	public ResponseEntity<ProdutoDTO> updateEditoraDTO(@RequestBody ProdutoDTO produtoDTO,
			@PathVariable Integer id) {
		return new ResponseEntity<>(produtoService.update(produtoDTO, id), HttpStatus.OK);
	}
}
