package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.CategoriaDTO;
import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.entity.Categoria;
import com.trabalhofinal.trabalho.entity.Cliente;
import com.trabalhofinal.trabalho.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    
	@Autowired
	private ModelMapper modelMapper;
	
	public List <CategoriaDTO> getAll(){
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		List<CategoriaDTO> listaCategoriaDTO = new ArrayList<>();
		for(Categoria categoria : listaCategoria) {
			CategoriaDTO categoriaDTO = converteEntitytoDTO(categoria);
			
			listaCategoriaDTO.add(categoriaDTO);
		}
		
		return listaCategoriaDTO;
	}
	
	public CategoriaDTO getById(int id) {
		Categoria categoria = categoriaRepository.findById(id).orElse(null);
		if (categoria != null) {
			return converteEntitytoDTO(categoria);
		} else {
			return null;
		}
	}
	
	public CategoriaDTO save(CategoriaDTO categoriaDTO) {
		Categoria categoria = toEntidade(categoriaDTO);
		Categoria novaCategoria = categoriaRepository.save(categoria);
		
		CategoriaDTO categoriaAtualizada = converteEntitytoDTO(novaCategoria);
		
		return categoriaAtualizada;
	}
	
	public List<CategoriaDTO> saveAllDTO(List<CategoriaDTO> categoriaDTO) {
		categoriaDTO.forEach(cat -> {
			//formatToUpperDTO(edt);
			categoriaRepository.save(toEntidade(cat));
		});
		return categoriaDTO;
	}
	
	//SALVANDO AO INVES DE DAR UPDATE
	public CategoriaDTO update(CategoriaDTO categoriaDTO,Integer id) {
		
		Categoria categoriaExistenteNoBanco = categoriaRepository.findById(id).orElse(null);
		CategoriaDTO categoriaAtualizadaDTO = new CategoriaDTO();
		if(categoriaExistenteNoBanco != null) {
			categoriaDTO.setNome(categoriaExistenteNoBanco.getNome());
			categoriaDTO.setDescricao(categoriaExistenteNoBanco.getDescricao());
			
			categoriaExistenteNoBanco = toEntidade(categoriaDTO);
			
			Categoria categoriaAtualizada = categoriaRepository.save(categoriaExistenteNoBanco);
			
			categoriaAtualizadaDTO = converteEntitytoDTO(categoriaAtualizada);
		}
		
		return categoriaAtualizadaDTO;
	}
	
	public CategoriaDTO delete(Integer id) {
		categoriaRepository.deleteById(id);
		
		return getById(id);
	}
	
//	public CategoriaDTO toDTO(Categoria categoria) {
//		CategoriaDTO categoriaDTO = new CategoriaDTO();
//		
//		categoriaDTO.setDescricao(categoria.getDescricao());
//		categoriaDTO.setNome(categoria.getNome());
//		
//		return categoriaDTO;
//	}
	
	public Categoria toEntidade(CategoriaDTO categoriaDTO) {
		 Categoria categoria = new Categoria();
		 
		 categoria.setNome(categoriaDTO.getNome());
		 categoria.setDescricao(categoriaDTO.getDescricao());
		return categoria;
	}
	
	private CategoriaDTO converteEntitytoDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO = (modelMapper.map(categoria, CategoriaDTO.class));
		return categoriaDTO;	
	}
}
