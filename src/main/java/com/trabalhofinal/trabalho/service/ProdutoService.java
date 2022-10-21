package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ProdutoDTO;
import com.trabalhofinal.trabalho.entity.Produto;
import com.trabalhofinal.trabalho.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List <ProdutoDTO> getAll(){
		List<Produto> lista = produtoRepository.findAll();
		List<ProdutoDTO> listaDTO = new ArrayList<>();
		for(Produto produto : lista) {
			ProdutoDTO produtoDTO = toDTO(produto);
			
			listaDTO.add(produtoDTO);
		}
		
		return listaDTO;
	}
	
	public ProdutoDTO getById(int id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
		if (produto != null) {
			return toDTO(produto);
		} else {
			return null;
		}
	}
	
	public ProdutoDTO save(ProdutoDTO enderecoDTO) {
		Produto produto = toEntidade(enderecoDTO);
		Produto novoProduto = produtoRepository.save(produto);
		
		ProdutoDTO produtoAtualizado = toDTO(novoProduto);
		
		return produtoAtualizado;
	}
	
	public ProdutoDTO update(ProdutoDTO produtoDTO,Integer id) {
		
		Produto produtoExistenteNoBanco = produtoRepository.findById(id).get();
		ProdutoDTO produtoAtualizadoDTO = new ProdutoDTO();
		if(produtoExistenteNoBanco != null) {
			produtoDTO.setCategoria(produtoExistenteNoBanco.getCategoria());
			produtoDTO.setDescricao(produtoExistenteNoBanco.getDescricao());
			produtoDTO.setImagem(produtoExistenteNoBanco.getImagem());
			produtoDTO.setQtdEstoque(produtoExistenteNoBanco.getQtdEstoque());
			produtoDTO.setNome(produtoExistenteNoBanco.getNome());
			
			produtoExistenteNoBanco = toEntidade(produtoDTO);
			
			Produto enderecoAtualizado = produtoRepository.save(produtoExistenteNoBanco);
			
			produtoAtualizadoDTO = toDTO(enderecoAtualizado);
		}
		
		return produtoAtualizadoDTO;
	}
	
	public ProdutoDTO delete(Integer id) {
		produtoRepository.deleteById(id);
		
		return getById(id);
	}
	
	public ProdutoDTO toDTO(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		produtoDTO.setCategoria(produto.getCategoria());
		produtoDTO.setDescricao(produto.getDescricao());
		//produtoDTO.setDtCadastro(produto.getDtCadastro());
		produtoDTO.setImagem(produto.getImagem());
		//produtoDTO.setItemPedido(produto.getItemPedido());
		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
		//produtoDTO.setVlUnitario(produto.getVlUnitario());
		
		return produtoDTO;
	}
	
	public Produto toEntidade(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();

		produto.setCategoria(produtoDTO.getCategoria());
		produto.setDescricao(produtoDTO.getDescricao());
		//produto.setDtCadastro(produtoDTO.getDtCadastro());
		produto.setImagem(produtoDTO.getImagem());
		//produto.setItemPedido(produtoDTO.getItemPedido());
		produto.setQtdEstoque(produtoDTO.getQtdEstoque());
		//produto.setVlUnitario(produtoDTO.getVlUnitario());

		return produto;
	}
}
