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

import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.service.ItemPedidoService;

@RestController
@RequestMapping("/itensPedido")
public class ItemPedidoController {
	@Autowired
	ItemPedidoService itemService;
	
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
   public ResponseEntity<List<ItemPedidoDTO>> getAll(){
       return new ResponseEntity<>(itemService.getAll(), HttpStatus.OK);
   } 
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<ItemPedidoDTO> getById(@PathVariable int id) {
		ItemPedidoDTO itemDTO = itemService.getById(id);
		if (itemDTO != null) {
			return new ResponseEntity<>(itemDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(itemDTO, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/dto")
   public ResponseEntity<ItemPedidoDTO> save(@RequestBody ItemPedidoDTO enderecoDTO) {
       return new ResponseEntity<>(itemService.save(enderecoDTO), HttpStatus.CREATED);
   }
	
	@PutMapping("/dto/{id}")
	public ResponseEntity<ItemPedidoDTO> updateEditoraDTO(@RequestBody ItemPedidoDTO itemDTO,
			@PathVariable Integer id) {
		return new ResponseEntity<>(itemService.update(itemDTO, id), HttpStatus.OK);
	}
}
