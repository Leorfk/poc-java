package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.repository.interfaces.IProdutoRepository;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
import com.leorfk.natureza.service.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public List<Produto> getAll() {
        return produtoRepository.buscarTodos();
    }

    @Override
    public void add(Produto produto) {
        produtoRepository.salvarProduto(produto);
    }

    @Override
    public Produto getById(String codigo) {
        Produto produto =  produtoRepository.buscarPorCodigo(codigo);
        if (produto == null){
            throw new ObjectNotFoundException("Produto com o código: " + codigo + " Não encontrado");
        }
        return produto;
    }

    @Override
    public void update(String codigo, Produto produto) {
        produtoRepository.alterarProduto(codigo, produto);
    }

    @Override
    public void delete(String codigo) {
        produtoRepository.apagarProduto(codigo);
    }
}
