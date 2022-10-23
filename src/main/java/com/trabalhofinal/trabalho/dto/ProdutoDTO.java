package com.trabalhofinal.trabalho.dto;

import java.time.Instant;
import java.util.List;

public class ProdutoDTO {
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private Instant dataCadastro;
	private Double valorUnitario;
	private String imagem;
	private CategoriaDTO categoriaDTO;
	private List<ItemPedidoDTO> pedidosDoProdutoDTO;


	//	Getters and Setters
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public List<ItemPedidoDTO> getPedidosDoProdutoDTO() {
		return pedidosDoProdutoDTO;
	}

	public void setPedidosDoProdutoDTO(List<ItemPedidoDTO> pedidosDoProdutoDTO) {
		this.pedidosDoProdutoDTO = pedidosDoProdutoDTO;
	}
}
