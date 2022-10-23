package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.entity.ItemPedido;
import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<PedidoDTO> getAll() {
		List<Pedido> lista = pedidoRepository.findAll();
		List<PedidoDTO> listaDTO = new ArrayList<>();
		for (Pedido pedido : lista) {
			PedidoDTO pedidoDTO = converteEntitytoDTO(pedido);

			listaDTO.add(pedidoDTO);
		}

		return listaDTO;
	}

	public PedidoDTO getById(int id) {
		Pedido pedido = pedidoRepository.findById(id).orElse(null);
		if (pedido != null) {
			return converteEntitytoDTO(pedido);
		} else {
			return null;
		}
	}

	public PedidoDTO save(PedidoDTO pedidoDTO) {
		pedidoDTO = formatToUpperDTO(pedidoDTO);
		Pedido pedido = toEntidade(pedidoDTO);
		Pedido novoPedido = pedidoRepository.save(pedido);

		PedidoDTO pedidoAtualizado = converteEntitytoDTO(novoPedido);

		return pedidoAtualizado;
	}

	public PedidoDTO update(PedidoDTO pedidoDTO, Integer id) {
		pedidoDTO = formatToUpperDTO(pedidoDTO);
		Pedido pedidoExistenteNoBanco = pedidoRepository.findById(id).get();
		PedidoDTO pedidoAtualizadoDTO = new PedidoDTO();

		if (pedidoExistenteNoBanco != null) {
			Pedido pedidoExistente = toEntidade(pedidoDTO);
			pedidoExistenteNoBanco.setDataEnvio(pedidoExistente.getDataEnvio());
			pedidoExistenteNoBanco.setStatus(pedidoExistente.getStatus());
			pedidoExistenteNoBanco.setValorTotal(pedidoExistente.getValorTotal());

			Pedido pedidoAtualizado = pedidoRepository.save(pedidoExistenteNoBanco);
			pedidoAtualizadoDTO = converteEntitytoDTO(pedidoAtualizado);
		}
		return pedidoAtualizadoDTO;
	}

	public PedidoDTO delete(Integer id) {
		pedidoRepository.deleteById(id);

		return getById(id);
	}

	public Pedido toEntidade(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();

//		pedido.setCliente(pedidoDTO.getCliente());
		pedido.setDataEntrega(pedidoDTO.getDataEntrega());
		pedido.setDataEnvio(pedidoDTO.getDataEnvio());
		pedido.setDataPedido(pedidoDTO.getDataPedido());
		pedido.setIdPedido(pedidoDTO.getIdPedido());
//		pedido.setItensPedidosFromDTO(pedidoDTO.getItensPedidosDTO());
		pedido.setStatus(pedidoDTO.getStatus());
		pedido.setValorTotal(pedidoDTO.getValorTotal());

		return pedido;
	}

	private PedidoDTO converteEntitytoDTO(Pedido pedido) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO = (modelMapper.map(pedido, PedidoDTO.class));
		return pedidoDTO;
	}

//	Format inputs to UpperCase
	private PedidoDTO formatToUpperDTO(PedidoDTO pedidoDTO) {
		pedidoDTO.setStatus(pedidoDTO.getStatus().toUpperCase());
		return pedidoDTO;
	}
}
