package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.dto.ProdutoDTO;
import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.entity.Produto;
import com.trabalhofinal.trabalho.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;

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

	public ProdutoDTO getById(int id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
		if (produto != null) {
			return converteEntitytoDTO(produto);
		} else {
			return null;
		}
	}

	public ProdutoDTO save(ProdutoDTO enderecoDTO) {
		Produto produto = toEntidade(enderecoDTO);
		Produto novoProduto = produtoRepository.save(produto);

		ProdutoDTO produtoAtualizado = converteEntitytoDTO(novoProduto);

		return produtoAtualizado;
	}

	public ProdutoDTO update(ProdutoDTO produtoDTO, Integer id) {

		Produto produtoExistenteNoBanco = produtoRepository.findById(id).orElse(null);
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

//	public ProdutoDTO toDTO(Produto produto) {
//		ProdutoDTO produtoDTO = new ProdutoDTO();
//		
//		produtoDTO.setCategoria(produto.getCategoria());
//		produtoDTO.setDescricao(produto.getDescricao());
//		//produtoDTO.setDtCadastro(produto.getDtCadastro());
//		produtoDTO.setImagem(produto.getImagem());
//		//produtoDTO.setItemPedido(produto.getItemPedido());
//		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
//		//produtoDTO.setVlUnitario(produto.getVlUnitario());
//		
//		return produtoDTO;
//	}

	public Produto toEntidade(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();

		produto.setCategoria(produtoDTO.getCategoria());
		produto.setDataCadastro(produtoDTO.getDataCadastro());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setImagem(produtoDTO.getImagem());
		produto.setNome(produtoDTO.getNome());
		produto.setPedidosDoProduto(produtoDTO.getPedidosDoProduto());
		produto.setQtdEstoque(produtoDTO.getQtdEstoque());
		produto.setValorUnitario(produtoDTO.getValorUnitario());
		return produto;
	}

	private ProdutoDTO converteEntitytoDTO(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO = (modelMapper.map(produto, ProdutoDTO.class));
		return produtoDTO;
	}
}
