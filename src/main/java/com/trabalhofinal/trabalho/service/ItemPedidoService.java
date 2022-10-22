package com.trabalhofinal.trabalho.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.dto.ItemPedidoDTO;
import com.trabalhofinal.trabalho.entity.Categoria;
import com.trabalhofinal.trabalho.entity.ItemPedido;
import com.trabalhofinal.trabalho.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    @Autowired
    ItemPedidoRepository itemPedidoRepository;

	public List<ItemPedidoDTO> getAll() {
		List<ItemPedido> lista = itemPedidoRepository.findAll();
		List<ItemPedidoDTO> listaDTO = new ArrayList<>();
		for (ItemPedido item : lista) {
			ItemPedidoDTO itemDTO = toDTO(item);

			listaDTO.add(itemDTO);
		}

		return listaDTO;
	}

	public ItemPedidoDTO getById(int id) {
		ItemPedido item = itemPedidoRepository.findById(id).orElse(null);
		if (item != null) {
			return toDTO(item);
		} else {
			return null;
		}
	}

	public ItemPedidoDTO save(ItemPedidoDTO itemDTO) {
		ItemPedido item = toEntidade(itemDTO);
		ItemPedido novoEndereco = itemPedidoRepository.save(item);

		ItemPedidoDTO itemAtualizado = toDTO(novoEndereco);

		return itemAtualizado;
	}
	
	public List<ItemPedidoDTO> saveAllDTO(List<ItemPedidoDTO> itemDTO) {
		itemDTO.forEach(edt -> {
			//formatToUpperDTO(edt);
			itemPedidoRepository.save(toEntidade(edt));
		});
		return itemDTO;
	}
	
	public ItemPedidoDTO update(ItemPedidoDTO itemDTO, Integer id) {

		ItemPedido itemExistenteNoBanco = itemPedidoRepository.findById(id).get();
		ItemPedidoDTO itemAtualizadoDTO = new ItemPedidoDTO();
		if (itemExistenteNoBanco != null) {
			itemDTO.setProduto(itemAtualizadoDTO.getProduto());
			itemDTO.setQuantidade(itemAtualizadoDTO.getQuantidade());

			itemExistenteNoBanco = toEntidade(itemDTO);

			ItemPedido itemAtualizado = itemPedidoRepository.save(itemExistenteNoBanco);

			itemAtualizadoDTO = toDTO(itemAtualizado);
		}

		return itemAtualizadoDTO;
	}

	public ItemPedidoDTO delete(Integer id) {
		itemPedidoRepository.deleteById(id);

		return getById(id);
	}

	public ItemPedidoDTO toDTO(ItemPedido item) {
		ItemPedidoDTO itemDTO = new ItemPedidoDTO();
		
		itemDTO.setIdItemPedido(item.getIdItemPedido());
		itemDTO.setQuantidade(item.getQuantidade());
		itemDTO.setProduto(item.getProduto());

		return itemDTO;
	}
	
//	private CategoriaDTO converteEntitytoDTO(Categoria categoria) {
//	CategoriaDTO categoriaDTO = new CategoriaDTO();
//	categoriaDTO = (modelMapper.map(categoria, CategoriaDTO.class));
//	return categoriaDTO;	
//}

	public ItemPedido toEntidade(ItemPedidoDTO itemDTO) {
		ItemPedido item = new ItemPedido();		
		item.setIdItemPedido(itemDTO.getIdItemPedido());
		item.setQuantidade(itemDTO.getQuantidade());
		item.setProduto(itemDTO.getProduto());

		return item;
	}
	
//	private CategoriaDTO converteDTOtoEntity(Categoria categoria) {
//	CategoriaDTO categoriaDTO = new CategoriaDTO();
//	categoriaDTO = (modelMapper.map(categoria, CategoriaDTO.class));
//	return categoriaDTO;	
//}
}
