package com.trabalhofinal.trabalho.dto;

import java.time.Instant;
import java.util.List;

public class RelatorioPedido {
	private Integer idPedido;
	private Instant dataPedido;
	private Double valorTotal;
	private List<ResumoPedido> resumo;
	
	
	public List<ResumoPedido> getResumo() {
		return resumo;
	}

	public void setResumo(List<ResumoPedido> resumo) {
		this.resumo = resumo;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
