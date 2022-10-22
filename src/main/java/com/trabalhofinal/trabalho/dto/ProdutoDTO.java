package com.trabalhofinal.trabalho.dto;

import java.time.Instant;
import java.util.List;

import com.trabalhofinal.trabalho.entity.Categoria;
import com.trabalhofinal.trabalho.entity.ItemPedido;

public class ProdutoDTO {
	private Integer idProduto;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private Instant dataCadastro;
	private Double valorUnitario;
	private String imagem;
	private Categoria categoria;
	private List<ItemPedido> pedidosDoProduto;

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public List<ItemPedido> getPedidosDoProduto() {
		return pedidosDoProduto;
	}

	public void setPedidosDoProduto(List<ItemPedido> pedidosDoProduto) {
		this.pedidosDoProduto = pedidosDoProduto;
	}
}
