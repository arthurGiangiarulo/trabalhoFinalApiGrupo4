package com.trabalhofinal.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.entity.Pedido;
import com.trabalhofinal.trabalho.repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
        //incluir tratamento/verificação para not found?
    }

    public Pedido getPedidoById(Integer id){
        return pedidoRepository.findById(id).orElse(null);
        //incluir tratamento/verificação para not found?
    }

    public Pedido savePedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
    
    public Pedido uptadePedido(Pedido pedido, Integer id){
        Pedido pedidoExistenteNoBanco = getPedidoById(id);
        pedidoExistenteNoBanco.setAllAtributos(pedido);
        return pedidoRepository.save(pedidoExistenteNoBanco);
    }

    public Pedido deletePedido(Integer id){
        pedidoRepository.deleteById(id);
        return getPedidoById(id);
    }
}
