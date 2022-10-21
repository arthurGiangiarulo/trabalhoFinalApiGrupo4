package com.trabalhofinal.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.entity.ItemPedido;
import com.trabalhofinal.trabalho.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItemPedidos(){
        return itemPedidoRepository.findAll();
        //incluir tratamento/verificação para not found?
    }

    public ItemPedido getItemPedidoById(Integer id){
        return itemPedidoRepository.findById(id).orElse(null);
        //incluir tratamento/verificação para not found?
    }

    public ItemPedido saveItemPedido(ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }
    
    public ItemPedido uptadeItemPedido(ItemPedido itemPedido, Integer id){
        ItemPedido itemPedidoExistenteNoBanco = getItemPedidoById(id);
        itemPedidoExistenteNoBanco.setAllAtributos(itemPedido);
        return itemPedidoRepository.save(itemPedidoExistenteNoBanco);
    }

    public ItemPedido deleteItemPedido(Integer id){
        itemPedidoRepository.deleteById(id);
        return getItemPedidoById(id);
    }
}
