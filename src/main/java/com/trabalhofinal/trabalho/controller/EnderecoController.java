//package com.trabalhofinal.trabalho.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.trabalhofinal.trabalho.dto.ClienteDTO;
//import com.trabalhofinal.trabalho.dto.EnderecoDTO;
//import com.trabalhofinal.trabalho.service.EnderecoService;
//
//@RestController
//@RequestMapping("/enderecos")
//public class EnderecoController {
//	@Autowired
//	EnderecoService enderecoService;
//
//// CONTROLLER DOS DTO's
//	@GetMapping("/search")
//	public ResponseEntity<List<EnderecoDTO>> getAll() {
//		return new ResponseEntity<>(enderecoService.getAll(), HttpStatus.OK);
//	}
//
//	@GetMapping("search/id/{id}")
//	public ResponseEntity<EnderecoDTO> getById(@PathVariable int id) {
//		EnderecoDTO enderecoDTO = enderecoService.getById(id);
//		if (enderecoDTO != null) {
//			return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(enderecoDTO, HttpStatus.NOT_FOUND);
//		}
//	}
//
//	@PostMapping("/save")
//	public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO enderecoDTO) {
//		return new ResponseEntity<>(enderecoService.save(enderecoDTO), HttpStatus.CREATED);
//	}
//
//	@PutMapping("/update/{id}")
//	public ResponseEntity<EnderecoDTO> updateEditoraDTO(@RequestBody EnderecoDTO enderecoDTO,
//			@PathVariable Integer id) {
//		return new ResponseEntity<>(enderecoService.update(enderecoDTO, id), HttpStatus.OK);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<EnderecoDTO> deleteClienteDTO(int id) {
//		EnderecoDTO enderecoDTO = enderecoService.getById(id);
//		if (enderecoDTO == null) {
//			return new ResponseEntity<>(enderecoDTO, HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(enderecoService.delete(id), HttpStatus.OK);
//		}
//	}
//}
