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
	private Instant dtCadastro;
	private Double vlUnitario;
	private String imagem;
	private Categoria categoria;
	private List <ItemPedido> itemPedido;
	
	
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
	public Instant getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Instant dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	public Double getVlUnitario() {
		return vlUnitario;
	}
	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
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
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
}
