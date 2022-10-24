package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ClienteDTO;
import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.dto.RelatorioPedido;
import com.trabalhofinal.trabalho.dto.ResumoPedido;
import com.trabalhofinal.trabalho.entity.ItemPedido;
import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ItemPedidoService itemService;
	
	@Autowired
	ClienteService clienteService;

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
		RelatorioPedido relatorio = relatorio(pedidoDTO);
		System.out.println(relatorio);
		pedidoDTO = formatToUpperDTO(pedidoDTO);
		
//		ClienteDTO cliente = clienteService.getById(id);
		Pedido pedido = toEntidade(pedidoDTO);
		Pedido novoPedido = pedidoRepository.save(pedido);

		PedidoDTO pedidoAtualizado = converteEntitytoDTO(novoPedido);

		return pedidoAtualizado;
	}
	
	public RelatorioPedido relatorio(PedidoDTO pedidoDTO) {
		List<ResumoPedido> listaResumo = new ArrayList<>();
		RelatorioPedido relatorio = new RelatorioPedido();
		relatorio.setIdPedido(pedidoDTO.getIdPedido());
		relatorio.setDataPedido(pedidoDTO.getDataPedido());
		relatorio.setValorTotal(pedidoDTO.getValorTotal());
		
		if(pedidoDTO.getItensPedidosDTO().size()> 0) {
			pedidoDTO.getItensPedidosDTO().forEach(item -> {
				ResumoPedido resumoTemp = new ResumoPedido();
				resumoTemp.setIdProduto(item.getProdutoDTO().getIdProduto());
				resumoTemp.setNome(item.getProdutoDTO().getNome());
				resumoTemp.setPercentualDesconto(item.getPercentualDesconto());
				resumoTemp.setPrecoVenda(item.getPrecoVenda());
				resumoTemp.setQuantidade(item.getQuantidade());
				resumoTemp.setValorBruto(item.getValorBruto());
				resumoTemp.setValorLiquido(item.getValorLiquido());
				listaResumo.add(resumoTemp);
			});
			relatorio.setResumo(listaResumo);
		}
		
		return relatorio;
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
