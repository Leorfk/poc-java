package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.service.interfaces.INaturezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
public class NaturezaController {

    @Autowired
    private INaturezaService naturezaService;

    @GetMapping
    public ResponseEntity<Natureza> getById(@RequestParam String codigo){
        Natureza natureza = naturezaService.getById(codigo);
        return ResponseEntity.ok().body(natureza);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Natureza natureza){
        naturezaService.add(natureza);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("natureza?codigo={codigo}").buildAndExpand(natureza.getCodigo()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Natureza>> getAll(){
        List<Natureza> naturezas = naturezaService.getAll();
        return ResponseEntity.ok().body(naturezas);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam String codigo, @RequestBody Natureza natureza){
        naturezaService.update(codigo, natureza);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String codigo){
        naturezaService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
