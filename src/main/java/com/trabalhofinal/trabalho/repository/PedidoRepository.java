package com.trabalhofinal.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.trabalhofinal.trabalho.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}
