package com.trabalhofinal.trabalho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trabalhofinal.trabalho.entity.Produto;
import com.trabalhofinal.trabalho.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos(){
        return produtoRepository.findAll();
        //incluir tratamento/verificação para not found?
    }

    public Produto getProdutoById(Integer id){
        return produtoRepository.findById(id).orElse(null);
        //incluir tratamento/verificação para not found?
    }

    public Produto saveProduto(Produto produto){
        return produtoRepository.save(produto);
    }
    
    public Produto uptadeProduto(Produto produto, Integer id){
        Produto produtoExistenteNoBanco = getProdutoById(id);
        produtoExistenteNoBanco.setAllAtributos(produto);
        return produtoRepository.save(produtoExistenteNoBanco);
    }

    public Produto deleteProduto(Integer id){
        produtoRepository.deleteById(id);
        return getProdutoById(id);
    }
}
