package com.trabalhofinal.trabalho.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trabalhofinal.trabalho.dto.ProdutoDTO;
import com.trabalhofinal.trabalho.entity.Produto;
import com.trabalhofinal.trabalho.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	private ModelMapper modelMapper;

	public List<ProdutoDTO> getAll() {
		List<Produto> lista = produtoRepository.findAll();
		List<ProdutoDTO> listaDTO = new ArrayList<>();
		for (Produto produto : lista) {
			ProdutoDTO produtoDTO = converteEntitytoDTO(produto);

			listaDTO.add(produtoDTO);
		}

		return listaDTO;
	}

	public ProdutoDTO getById(Integer id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
		if (produto != null) {
			return converteEntitytoDTO(produto);
		} else {
			return null;
		}
	}

	public ProdutoDTO save(ProdutoDTO produtoDTO) {
		produtoDTO = formatToUpperDTO(produtoDTO);
		Produto produto = toEntidade(produtoDTO);
		Produto novoProduto = produtoRepository.save(produto);
		ProdutoDTO produtoAtualizado = converteEntitytoDTO(novoProduto);

		return produtoAtualizado;
	}
	
	public ProdutoDTO saveProdutoImgDatabase(String produtoJson, MultipartFile foto)  {
		ProdutoDTO produtoFromJson = convertProdutoFromStringJson(produtoJson);
		String fileName = StringUtils.cleanPath(foto.getOriginalFilename());
		try {
			produtoFromJson.setImagem(Base64.getEncoder().encodeToString(foto.getBytes()));
		} catch (Exception e) {
				e.printStackTrace();
		}
		produtoRepository.save(toEntidade(produtoFromJson));
		return produtoFromJson;
	}
	
	private ProdutoDTO convertProdutoFromStringJson(String produtoJson) {
		ProdutoDTO produto = new ProdutoDTO();
		
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			produto = objectMapper.readValue(produtoJson, ProdutoDTO.class);
		} catch (IOException err) {
			System.out.printf("Ocorreu um erro ao tentar converter a string json para um instância da entidade ProdutoDTO", err.toString());
		}
		return produto;
	}

	public ProdutoDTO update(ProdutoDTO produtoDTO, Integer id) {
		produtoDTO = formatToUpperDTO(produtoDTO);
		Produto produtoExistenteNoBanco = produtoRepository.findById(id).get();
		ProdutoDTO produtoAtualizadoDTO = new ProdutoDTO();

		if (produtoExistenteNoBanco != null) {
			Produto produtoExistente = toEntidade(produtoDTO);

			produtoExistenteNoBanco.setDescricao(produtoExistente.getDescricao());
			produtoExistenteNoBanco.setNome(produtoExistente.getNome());
			produtoExistenteNoBanco.setQtdEstoque(produtoExistente.getQtdEstoque());
			produtoExistenteNoBanco.setValorUnitario(produtoExistente.getValorUnitario());
			Produto produtoAtualizado = produtoRepository.save(produtoExistenteNoBanco);
			produtoAtualizadoDTO = converteEntitytoDTO(produtoAtualizado);
		}
		return produtoAtualizadoDTO;
	}

	public ProdutoDTO delete(Integer id) {
		produtoRepository.deleteById(id);
		return getById(id);
	}

	public Produto toEntidade(ProdutoDTO produtoDTO) {
		Produto produto = (modelMapper.map(produtoDTO, Produto.class));
		return produto;
	}

	private ProdutoDTO converteEntitytoDTO(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO = (modelMapper.map(produto, ProdutoDTO.class));
		return produtoDTO;
	}

	// Format inputs to UpperCase
	private ProdutoDTO formatToUpperDTO(ProdutoDTO produtoDTO) {
		produtoDTO.setNome(produtoDTO.getNome().toUpperCase());
		produtoDTO.setDescricao(produtoDTO.getDescricao().toUpperCase());
		return produtoDTO;
	}
}
