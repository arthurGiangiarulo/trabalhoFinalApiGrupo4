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

import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
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
   public ResponseEntity<List<PedidoDTO>> getAll(){
       return new ResponseEntity<>(pedidoService.getAll(), HttpStatus.OK);
   } 
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<PedidoDTO> getById(@PathVariable int id) {
		PedidoDTO pedidoDTO = pedidoService.getById(id);
		if (pedidoDTO != null) {
			return new ResponseEntity<>(pedidoDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(pedidoDTO, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/dto")
   public ResponseEntity<PedidoDTO> save(@RequestBody PedidoDTO pedidoDTO) {
       return new ResponseEntity<>(pedidoService.save(pedidoDTO), HttpStatus.CREATED);
   }
	
	@PutMapping("/dto/{id}")
	public ResponseEntity<PedidoDTO> updateEditoraDTO(@RequestBody PedidoDTO pedidoDTO,
			@PathVariable Integer id) {
		return new ResponseEntity<>(pedidoService.update(pedidoDTO, id), HttpStatus.OK);
	}
}
