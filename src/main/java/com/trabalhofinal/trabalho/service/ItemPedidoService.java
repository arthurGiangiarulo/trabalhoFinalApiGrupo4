package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.dto.PedidoDTO;
import com.trabalhofinal.trabalho.entity.ItemPedido;
import com.trabalhofinal.trabalho.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<ItemPedidoDTO> getAll() {
		List<ItemPedido> lista = itemPedidoRepository.findAll();
		List<ItemPedidoDTO> listaDTO = new ArrayList<>();
		for (ItemPedido item : lista) {
			ItemPedidoDTO itemDTO = converteEntitytoDTO(item);

			listaDTO.add(itemDTO);
		}

		return listaDTO;
	}

	public ItemPedidoDTO getById(int id) {
		ItemPedido item = itemPedidoRepository.findById(id).orElse(null);
		if (item != null) {
			return converteEntitytoDTO(item);
		} else {
			return null;
		}
	}

	public ItemPedidoDTO save(ItemPedidoDTO itemDTO) {
		ItemPedido item = toEntidade(itemDTO);
		ItemPedido novoEndereco = itemPedidoRepository.save(item);

		ItemPedidoDTO itemAtualizado = converteEntitytoDTO(novoEndereco);

		return itemAtualizado;
	}

	public ItemPedidoDTO update(ItemPedidoDTO itemDTO, Integer id) {
		ItemPedido itemExistenteNoBanco = itemPedidoRepository.findById(id).orElse(null);
		ItemPedidoDTO itemAtualizadoDTO = new ItemPedidoDTO();

		if (itemExistenteNoBanco != null) {
			itemDTO.setProduto(itemAtualizadoDTO.getProduto());
			itemDTO.setQuantidade(itemAtualizadoDTO.getQuantidade());
			itemExistenteNoBanco = toEntidade(itemDTO);

			ItemPedido itemAtualizado = itemPedidoRepository.save(itemExistenteNoBanco);

			itemAtualizadoDTO = converteEntitytoDTO(itemAtualizado);

		}
		return itemAtualizadoDTO;
	}
	
	public ItemPedidoDTO delete(Integer id) {
		itemPedidoRepository.deleteById(id);
		return getById(id);
	}

	public ItemPedido toEntidade(ItemPedidoDTO itemDTO) {
		ItemPedido item = (modelMapper.map(itemDTO, ItemPedido.class));
		System.out.println(item.getProduto().getIdProduto());
		return item;
	}

	public ItemPedidoDTO converteEntitytoDTO(ItemPedido item) {
		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
		itemPedidoDTO = (modelMapper.map(item, ItemPedidoDTO.class));
		return itemPedidoDTO;
	}
}
