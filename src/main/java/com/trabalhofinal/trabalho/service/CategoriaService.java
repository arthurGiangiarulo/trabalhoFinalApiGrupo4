package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.CategoriaDTO;
import com.trabalhofinal.trabalho.entity.Categoria;
import com.trabalhofinal.trabalho.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
	
	public List <CategoriaDTO> getAll(){
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		List<CategoriaDTO> listaCategoriaDTO = new ArrayList<>();
		for(Categoria categoria : listaCategoria) {
			CategoriaDTO categoriaDTO = toDTO(categoria);
			
			listaCategoriaDTO.add(categoriaDTO);
		}
		
		return listaCategoriaDTO;
	}
	
	public CategoriaDTO getById(int id) {
		Categoria categoria = categoriaRepository.findById(id).orElse(null);
		if (categoria != null) {
			return toDTO(categoria);
		} else {
			return null;
		}
	}
	
	public CategoriaDTO save(CategoriaDTO categoriaDTO) {
		Categoria categoria = toEntidade(categoriaDTO);
		Categoria novaCategoria = categoriaRepository.save(categoria);
		
		CategoriaDTO categoriaAtualizada = toDTO(novaCategoria);
		
		return categoriaAtualizada;
	}
	
	public CategoriaDTO update(CategoriaDTO categoriaDTO,Integer id) {
		
		Categoria categoriaExistenteNoBanco = categoriaRepository.findById(id).get();
		CategoriaDTO categoriaAtualizadaDTO = new CategoriaDTO();
		if(categoriaExistenteNoBanco != null) {
			categoriaDTO.setNome(categoriaExistenteNoBanco.getNome());
			categoriaDTO.setDescricao(categoriaExistenteNoBanco.getDescricao());
			
			categoriaExistenteNoBanco = toEntidade(categoriaDTO);
			
			Categoria categoriaAtualizada = categoriaRepository.save(categoriaExistenteNoBanco);
			
			categoriaAtualizadaDTO = toDTO(categoriaAtualizada);
		}
		
		return categoriaAtualizadaDTO;
	}
	
	public CategoriaDTO delete(Integer id) {
		categoriaRepository.deleteById(id);
		
		return getById(id);
	}
	
	public CategoriaDTO toDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		categoriaDTO.setDescricao(categoria.getDescricao());
		categoriaDTO.setNome(categoria.getNome());
		
		return categoriaDTO;
	}
	
	public Categoria toEntidade(CategoriaDTO categoriaDTO) {
		 Categoria categoria = new Categoria();
		 
		 categoria.setNome(categoriaDTO.getNome());
		 categoria.setDescricao(categoria.getDescricao());
		return categoria;
	}
}
