package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Produto;
import com.leorfk.natureza.service.interfaces.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Produto> getById(@RequestParam String codigo){
        Produto produto = produtoService.getById(codigo);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Produto produto){
        produtoService.add(produto);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Produto>> getAll(){
        List<Produto> produtos = produtoService.getAll();
        return ResponseEntity.ok().body(produtos);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam String codigo, @RequestBody Produto produto){

        produtoService.update(codigo, produto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String codigo){
        produtoService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
