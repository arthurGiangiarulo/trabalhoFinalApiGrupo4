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
//
//@RestController
//@RequestMapping("/enderecos")
//public class EnderecoController {
//	@Autowired
//	EnderecoService enderecoService;
//	
////// CONTROLLER DAS ENTITY --------------------------------------------------------------------------------
////	@GetMapping
////    public ResponseEntity<List<Categoria>> getAllCategoria(){
////        return new ResponseEntity<>(categoriaService.getAllCategoria(), HttpStatus.OK);
////    }
////	
////	@GetMapping("/{id}")
////	public ResponseEntity<Categoria> getCategoriaById(@PathVariable int id) {
////		Categoria categoria = categoriaService.getCategoriaById(id);
////		if (categoria != null) {
////			return new ResponseEntity<>(categoria, HttpStatus.OK);
////		} else {
////			return new ResponseEntity<>(categoria, HttpStatus.NOT_FOUND);
////		}
////	}
////	
////	@PostMapping
////	public ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria) {
////		return new ResponseEntity<>(categoriaService.saveCategoria(categoria), HttpStatus.OK);
////	}
////	
////	@PutMapping("/{id}")
////	public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable int id) {
////		return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id), HttpStatus.OK);		
////	}
////// FIM DO CONTROLLER DAS ENITY -----------------------------------------------------------------------------------
//
//// CONTROLLER DOS DTO
//	@GetMapping("/dto") 
//    public ResponseEntity<List<EnderecoDTO>> getAll(){
//        return new ResponseEntity<>(enderecoService.getAll(), HttpStatus.OK);
//    } 
//	
//	@GetMapping("/dto/{id}")
//	public ResponseEntity<EnderecoDTO> getById(@PathVariable int id) {
//		EnderecoDTO enderecoDTO = enderecoService.getById(id);
//		if (enderecoDTO != null) {
//			return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(enderecoDTO, HttpStatus.NOT_FOUND);
//		}
//	}
//	
//	@PostMapping("/dto")
//    public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO enderecoDTO) {
//        return new ResponseEntity<>(enderecoService.save(enderecoDTO), HttpStatus.CREATED);
//    }
//	
//	@PutMapping("/dto/{id}")
//	public ResponseEntity<EnderecoDTO> updateEditoraDTO(@RequestBody EnderecoDTO enderecoDTO,
//			@PathVariable Integer id) {
//		return new ResponseEntity<>(enderecoService.update(enderecoDTO, id), HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/dto/delete")
//	public ResponseEntity<EnderecoDTO> deleteClienteDTO(int id) {
//		EnderecoDTO enderecoDTO = enderecoService.getById(id);
//		if (enderecoDTO == null) {
//			return new ResponseEntity<>(enderecoDTO, HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(enderecoService.delete(id), HttpStatus.OK);
//		}
//	}
//}
