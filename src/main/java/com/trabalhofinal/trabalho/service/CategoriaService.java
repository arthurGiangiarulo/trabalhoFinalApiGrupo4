package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.CategoriaDTO;
import com.trabalhofinal.trabalho.dto.ClienteDTO;
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
	
	public CategoriaDTO update(CategoriaDTO categoriaDTO, Integer id) {

		Categoria categoriaExistenteNoBanco = categoriaRepository.findById(id).orElse(null);
		CategoriaDTO categoriaAtualizadoDTO = new CategoriaDTO();
		
		if (categoriaExistenteNoBanco != null) {
			
			Categoria categoriaExistente = toEntidade(categoriaDTO);
			
			categoriaExistenteNoBanco.setDescricao(categoriaExistente.getDescricao());
			categoriaExistenteNoBanco.setNome(categoriaExistente.getNome());
			
			Categoria categoriaAtualizado = categoriaRepository.save(categoriaExistenteNoBanco);
			
			categoriaAtualizadoDTO = converteEntitytoDTO(categoriaAtualizado);
			 
		}
		return categoriaAtualizadoDTO;
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
