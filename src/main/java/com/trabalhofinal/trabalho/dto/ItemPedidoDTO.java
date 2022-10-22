package com.trabalhofinal.trabalho.dto;

import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.entity.Produto;

public class ItemPedidoDTO {
	private Integer idItemPedido;
	private Integer quantidade;
	private Double precoVenda;
	private Double percentualDesconto;
	private Double valorBruto;
	private Double valorLiquido;
	private Pedido pedido;
	private Produto produto;

//	Getters and Setters
	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto(Double precoVenda, int quantidade) {
		return valorBruto = (precoVenda*quantidade);
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido(Double valorBruto, Double percentualDesconto) {
		return valorLiquido = valorBruto-(valorBruto*percentualDesconto/100);
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
