package com.trabalhofinal.trabalho.entity;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.trabalhofinal.trabalho.dto.ClienteDTO;
import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.service.ClienteService;
import com.trabalhofinal.trabalho.service.ItemPedidoService;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Autowired
	ItemPedidoService itemPedidoService;

	@Autowired
	ClienteService clienteService;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer idPedido;
	
	@Column(name = "data_pedido")
	private Instant dataPedido;
	
	@Column(name = "data_entrega")
	private Instant dataEntrega;
	
	@Column(name = "data_envio")
	private Instant dataEnvio;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "valorTotal")
	private Double valorTotal;
	
	@OneToMany(mappedBy = "pedido")
	private List <ItemPedido> itensPedidos;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;
	

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

	public Instant getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Instant getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Instant dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public void setItensPedidosFromDTO(List<ItemPedidoDTO> itensPedidosDTO) {
		for(ItemPedidoDTO itemPedidoDTO: itensPedidosDTO)
			this.itensPedidos.add(itemPedidoService.toEntidade(itemPedidoDTO));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setClienteFromDTO(ClienteDTO clienteDTO) {
		this.cliente = clienteService.toEntidade(clienteDTO);
	}

	public Pedido setAllAtributos(Pedido pedido){
		this.setDataPedido(pedido.getDataPedido());
		this.setDataEntrega(pedido.getDataEntrega());
		this.setDataEnvio(pedido.getDataEnvio());
		this.setStatus(pedido.getStatus());
		this.setValorTotal(pedido.getValorTotal());
		this.setItensPedidos(pedido.getItensPedidos());
		this.setCliente(pedido.getCliente());
		return this;
	}
	
}
