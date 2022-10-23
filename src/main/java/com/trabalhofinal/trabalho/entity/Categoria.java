package com.trabalhofinal.trabalho.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.trabalhofinal.trabalho.dto.ProdutoDTO;
import com.trabalhofinal.trabalho.service.ProdutoService;

@Entity
@Table(name = "categoria")
public class Categoria {
//	@Autowired
//	ProdutoService produtoService;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;
	
	@Column(name = "nome") 
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos;


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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

//	public void setProdutosFromDTO(List<ProdutoDTO> produtosDTO){
//		for(ProdutoDTO produtoDTO: produtosDTO){
//			this.produtos.add(produtoService.toEntidade(produtoDTO)); 
//		}
//	}
	
	public Categoria setAllAtributos(Categoria categoria){
		this.setNome(categoria.getNome());
		this.setDescricao(categoria.getDescricao());
		return this;
	}
}

