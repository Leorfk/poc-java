package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.repository.interfaces.ICrudRepository;
import com.leorfk.natureza.repository.interfaces.IProdutoRepository;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
import com.leorfk.natureza.service.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private ICrudRepository<Produto> produtoRepository;

    @Override
    public List<Produto> getAll() {
        return produtoRepository.getAll();
    }

    @Override
    public void add(Produto produto) {
        produtoRepository.add(produto);
    }

    @Override
    public Produto getById(String codigo) {
        Produto produto =  produtoRepository.getById(codigo);
        if (produto == null){
            throw new ObjectNotFoundException("Produto com o código: " + codigo + " Não encontrado");
        }
        return produto;
    }

    @Override
    public void update(String codigo, Produto produto) {
        produtoRepository.update(codigo, produto);
    }

    @Override
    public void delete(String codigo) {
        produtoRepository.delete(codigo);
    }
}
