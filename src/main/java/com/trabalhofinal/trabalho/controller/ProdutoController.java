package com.trabalhofinal.trabalho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.trabalhofinal.trabalho.dto.ProdutoDTO;
import com.trabalhofinal.trabalho.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;

//CONTROLLER DOS DTO's
	@GetMapping("/search")
   public ResponseEntity<List<ProdutoDTO>> getAll(){
       return new ResponseEntity<>(produtoService.getAll(), HttpStatus.OK);
   } 
	
	@GetMapping("/search/id/{id}")
	public ResponseEntity<ProdutoDTO> getById(@PathVariable int id) {
		ProdutoDTO produtoDTO = produtoService.getById(id);
		if (produtoDTO != null) {
			return new ResponseEntity<>(produtoDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(produtoDTO, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/save")
   public ResponseEntity<ProdutoDTO> save(@RequestBody ProdutoDTO produtoDTO) {
       return new ResponseEntity<>(produtoService.save(produtoDTO), HttpStatus.CREATED);
   }
	
   @PostMapping(value = "/save/produtoImagem",
			consumes = {MediaType.APPLICATION_JSON_VALUE,
						MediaType.MULTIPART_FORM_DATA_VALUE})
   public ResponseEntity<ProdutoDTO> save(@RequestPart("produto") String produtoDTO, @RequestPart("image") MultipartFile foto) {
		try {
			return new ResponseEntity<>(produtoService.saveProdutoImgDatabase(produtoDTO, foto), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		return new ResponseEntity<>(produtoService.saveProdutoImgDatabase(produtoDTO, foto), HttpStatus.BAD_REQUEST);
		}
   }
		
	@PutMapping("/update/{id}")
	public ResponseEntity<ProdutoDTO> updateProdutoDTO(@RequestBody ProdutoDTO produtoDTO,
			@PathVariable Integer id) {
		return new ResponseEntity<>(produtoService.update(produtoDTO, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ProdutoDTO> deleteProdutoDTO(Integer id) {
		ProdutoDTO produtoDTO = produtoService.getById(id);
		if (produtoDTO == null) {
			return new ResponseEntity<>(produtoDTO, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(produtoService.delete(id), HttpStatus.OK);
		}
	}
}
