package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.service.interfaces.INaturezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/natureza")
public class NaturezaController {

    @Autowired
    private INaturezaService naturezaService;

    @GetMapping("{id}")
    public ResponseEntity<Natureza> getById(@PathVariable("id") Integer id){
        Natureza natureza = naturezaService.getById(id);
        return ResponseEntity.ok().body(natureza);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Natureza natureza){
        naturezaService.add(natureza);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Natureza>> getAll(){
        List<Natureza> naturezas = naturezaService.getAll();
        return ResponseEntity.ok().body(naturezas);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam int id, @RequestBody Natureza natureza){
        natureza.setId(id);
        naturezaService.update(natureza);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam int id){
        naturezaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
