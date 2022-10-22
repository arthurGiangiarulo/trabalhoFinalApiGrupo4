package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ProdutoDTO;
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

		Produto produtoExistenteNoBanco = produtoRepository.findById(id).get();
		ProdutoDTO produtoAtualizadoDTO = new ProdutoDTO();
		if (produtoExistenteNoBanco != null) {
			//produtoDTO.setCategoriaDTO(produtoExistenteNoBanco.getCategoria());
			produtoDTO.setDescricao(produtoExistenteNoBanco.getDescricao());
			produtoDTO.setImagem(produtoExistenteNoBanco.getImagem());
			produtoDTO.setQtdEstoque(produtoExistenteNoBanco.getQtdEstoque());
			produtoDTO.setNome(produtoExistenteNoBanco.getNome());

			produtoExistenteNoBanco = toEntidade(produtoDTO);

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

		//produto.setCategoria(produtoDTO.getCategoria());
		produto.setDataCadastro(produtoDTO.getDataCadastro());
		produto.setDescricao(produtoDTO.getDescricao());
		produto.setImagem(produtoDTO.getImagem());
		produto.setNome(produtoDTO.getNome());
		//produto.setPedidosDoProduto(produtoDTO.getPedidosDoProdutoDTO());
		produto.setPedidosDoProdutoFromDTO(produtoDTO.getPedidosDoProdutoDTO());
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
