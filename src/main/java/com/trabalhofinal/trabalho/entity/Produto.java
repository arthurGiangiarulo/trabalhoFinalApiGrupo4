package com.trabalhofinal.trabalho.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
//	@Autowired
//	ItemPedidoService itemPedidoService;
//
//	@Autowired
//	CategoriaService categoriaService;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer idProduto;

	@Column(name = "nome", unique = true)
	private String nome;

	@Column(name = "descricao", unique = true)
	private String descricao;

	@Column(name = "qtd_estoque")
	private Integer qtdEstoque;

	@Column(name = "data_cadastro")
	private Instant dataCadastro;

	@Column(name = "valor_unitario")
	private Double valorUnitario;

	@Lob
	@Column(name = "imagem")
	private byte[] imagem;

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categoria categoria;

	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> pedidosDoProduto;

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
	
	

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
//	public void setCategoriaFromDTO(CategoriaDTO categoriaDTO){
//		this.categoria = categoriaService.toEntidade(categoriaDTO);
//	}

	public List<ItemPedido> getPedidosDoProduto() {
		return pedidosDoProduto;
	}

	public void setPedidosDoProduto(List<ItemPedido> pedidosDoProduto) {
		this.pedidosDoProduto = pedidosDoProduto;
	}

//	public void setPedidosDoProdutoFromDTO(List<ItemPedidoDTO> pedidosDoProdutoDTO) {
//		for(ItemPedidoDTO itemPedidoDTO: pedidosDoProdutoDTO){
//			this.pedidosDoProduto.add(itemPedidoService.toEntidade(itemPedidoDTO));
//		}
//	}

	public Produto setAllAtributos(Produto produto) {
		this.setNome(nome);
		this.setNome(produto.getNome());
		this.setDescricao(produto.getDescricao());
		this.setQtdEstoque(produto.getQtdEstoque());
		this.setDataCadastro(produto.getDataCadastro());
		this.setValorUnitario(produto.getValorUnitario());
		this.setImagem(produto.getImagem());
		this.setCategoria(produto.getCategoria());
		this.setPedidosDoProduto(produto.getPedidosDoProduto());
		return this;
	}
}
