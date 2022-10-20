package com.trabalhofinal.trabalho.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalhofinal.trabalho.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
