package com.trabalhofinal.trabalho.dto;

import java.util.List;

public class CategoriaDTO {
	private Integer idCategoria;
	private String nome;
	private String descricao;
	private List<ProdutoDTO> produtoDTO;
	

	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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
	public List<ProdutoDTO> getProdutoDTO() {
		return produtoDTO;
	}
	public void setProdutoDTO(List<ProdutoDTO> produtoDTO) {
		this.produtoDTO = produtoDTO;
	}
	
}
