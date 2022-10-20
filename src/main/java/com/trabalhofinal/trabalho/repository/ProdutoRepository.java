package com.trabalhofinal.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.trabalho.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
