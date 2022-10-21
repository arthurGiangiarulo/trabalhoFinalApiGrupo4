package com.trabalhofinal.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.entity.Categoria;
import com.trabalhofinal.trabalho.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
        //incluir tratamento/verificação para not found?
    }

    public Categoria getCategoriaById(Integer id){
        return categoriaRepository.findById(id).orElse(null);
        //incluir tratamento/verificação para not found?
    }

    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    public Categoria uptadeCategoria(Categoria categoria, Integer id){
        Categoria categoriaExistenteNoBanco = getCategoriaById(id);
        categoriaExistenteNoBanco.setAllAtributos(categoria);
        return categoriaRepository.save(categoriaExistenteNoBanco);
    }

    public Categoria deleteCategoria(Integer id){
        categoriaRepository.deleteById(id);
        return getCategoriaById(id);
    }
    
    // public Categoria deleteCategoria(Integer id){
    //     Categoria categoria = getCategoriaById(id);
        
    //     //Incluir tratamento para id not found
    //     if(categoria != null){
    //         categoriaRepository.deleteById(id);
    //         return categoria;
    //     } else {
    //         return categoria;
    //     }
    // }

}
