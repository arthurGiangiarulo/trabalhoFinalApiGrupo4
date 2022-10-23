package com.trabalhofinal.trabalho.dto;

import java.util.List;

public class ClienteDTO {
	private Integer idCliente;
	private String email;
	private String nomeCompleto;
	private String cpf;
	private String telefone;
	private String dataNascimento;
	private EnderecoDTO enderecoDTO;
	private List <PedidoDTO> pedidoDTO;
	

//	Getters and Setters
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}
	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}
	public List<PedidoDTO> getPedidoDTO() {
		return pedidoDTO;
	}
	public void setPedidoDTO(List<PedidoDTO> pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
	}
	
}
