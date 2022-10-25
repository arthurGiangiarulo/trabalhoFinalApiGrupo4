package com.trabalhofinal.trabalho.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.trabalho.entity.ItemPedido;
import com.trabalhofinal.trabalho.entity.Pedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{
    
	public List<ItemPedido> findByPedido(Pedido pedido);
	
}
