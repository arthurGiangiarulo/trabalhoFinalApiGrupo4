package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.CategoriaDTO;
import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

	public List <PedidoDTO> getAll(){
		List<Pedido> lista = pedidoRepository.findAll();
		List<PedidoDTO> listaDTO = new ArrayList<>();
		for(Pedido pedido : lista) {
			PedidoDTO pedidoDTO = toDTO(pedido);
			
			listaDTO.add(pedidoDTO);
		}
		
		return listaDTO;
	}
	
	public PedidoDTO getById(int id) {
		Pedido pedido = pedidoRepository.findById(id).orElse(null);
		if (pedido != null) {
			return toDTO(pedido);
		} else {
			return null;
		}
	}
	
	public PedidoDTO save(PedidoDTO pedidoDTO) {
		Pedido pedido = toEntidade(pedidoDTO);
		Pedido novoPedido = pedidoRepository.save(pedido);
		
		PedidoDTO pedidoAtualizado = toDTO(novoPedido);
		
		return pedidoAtualizado;
	}
	
	public List<PedidoDTO> saveAllDTO(List<PedidoDTO> pedidoDTO) {
		pedidoDTO.forEach(ped -> {
			//formatToUpperDTO(edt);
			pedidoRepository.save(toEntidade(ped));
		});
		return pedidoDTO;
	}
	
	public PedidoDTO update(PedidoDTO pedidoDTO,Integer id) {
		
		Pedido pedidoExistenteNoBanco = pedidoRepository.findById(id).get();
		PedidoDTO pedidoAtualizadoDTO = new PedidoDTO();
		if(pedidoExistenteNoBanco != null) {
			pedidoDTO.setStatus(pedidoAtualizadoDTO.getStatus());
			pedidoDTO.setCliente(pedidoAtualizadoDTO.getCliente());
			pedidoDTO.setItemPedido(pedidoAtualizadoDTO.getItemPedido());
			pedidoDTO.setVlTotal(pedidoAtualizadoDTO.getVlTotal());
			
			pedidoExistenteNoBanco = toEntidade(pedidoDTO);
			
			Pedido pedidoAtualizado = pedidoRepository.save(pedidoExistenteNoBanco);
			
			pedidoAtualizadoDTO = toDTO(pedidoAtualizado);
		}
		
		return pedidoAtualizadoDTO;
	}
	
	public PedidoDTO delete(Integer id) {
		pedidoRepository.deleteById(id);
		
		return getById(id);
	}
	
	public PedidoDTO toDTO(Pedido pedido) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		
		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setCliente(pedido.getCliente());;
		pedidoDTO.setDtEntrega(pedido.getDataEntrega());
		pedidoDTO.setDtEnvio(pedido.getDataEnvio());
		pedidoDTO.setDtPedido(pedido.getDataPedido());
		pedidoDTO.setStatus(pedido.getStatus());
		pedidoDTO.setVlTotal(pedido.getValorTotal());
		
		return pedidoDTO;
	}
	
	public Pedido toEntidade(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		 
		pedido.setIdPedido(pedidoDTO.getIdPedido());
		pedido.setCliente(pedidoDTO.getCliente());;
		pedido.setDataEntrega(pedidoDTO.getDtEntrega());
		pedido.setDataEnvio(pedidoDTO.getDtEnvio());
		pedido.setDataPedido(pedidoDTO.getDtPedido());
		pedido.setStatus(pedidoDTO.getStatus());
		pedido.setValorTotal(pedidoDTO.getVlTotal());
		
		return pedido;
	}
}
