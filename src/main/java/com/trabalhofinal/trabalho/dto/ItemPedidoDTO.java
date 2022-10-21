package com.trabalhofinal.trabalho.dto;

import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.entity.Produto;

public class ItemPedidoDTO {
	private Integer idItemPedido;
	private Integer quantidade;
	private Double precoVenda;
	private Double percDesconto;
	private Double vlBruto;
	private Double vlLiquido;
	private Pedido pedido;
	private Produto produto;
	
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
	public Double getPercDesconto() {
		return percDesconto;
	}
	public void setPercDesconto(Double percDesconto) {
		this.percDesconto = percDesconto;
	}
	public Double getVlBruto() {
		return vlBruto;
	}
	public void setVlBruto(Double vlBruto) {
		this.vlBruto = vlBruto;
	}
	public Double getVlLiquido() {
		return vlLiquido;
	}
	public void setVlLiquido(Double vlLiquido) {
		this.vlLiquido = vlLiquido;
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
