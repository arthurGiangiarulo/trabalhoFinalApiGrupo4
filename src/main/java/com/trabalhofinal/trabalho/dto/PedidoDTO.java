package com.trabalhofinal.trabalho.dto;

import java.time.Instant;
import java.util.List;

import com.trabalhofinal.trabalho.entity.Cliente;
import com.trabalhofinal.trabalho.entity.ItemPedido;

public class PedidoDTO {
	private Integer idPedido;
	private Instant dtPedido;
	private Instant dtEntrega;
	private Instant dtEnvio;
	private String status;
	private Double vlTotal;
	private List <ItemPedido> itemPedido;
	private Cliente cliente;
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public Instant getDtPedido() {
		return dtPedido;
	}
	public void setDtPedido(Instant dtPedido) {
		this.dtPedido = dtPedido;
	}
	public Instant getDtEntrega() {
		return dtEntrega;
	}
	public void setDtEntrega(Instant dtEntrega) {
		this.dtEntrega = dtEntrega;
	}
	public Instant getDtEnvio() {
		return dtEnvio;
	}
	public void setDtEnvio(Instant dtEnvio) {
		this.dtEnvio = dtEnvio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getVlTotal() {
		return vlTotal;
	}
	public void setVlTotal(Double vlTotal) {
		this.vlTotal = vlTotal;
	}
	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
