package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Recolhimento;
import com.leorfk.natureza.service.interfaces.IRecolhimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recolhimento")
public class RecolhimentoController {

    @Autowired
    private IRecolhimentoService recolhimentoService;

    @GetMapping
    public ResponseEntity<Recolhimento> getById(@RequestParam String codigo){
        Recolhimento recolhimento = recolhimentoService.getById(codigo);
        return ResponseEntity.ok().body(recolhimento);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Recolhimento recolhimento){
        recolhimentoService.add(recolhimento);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<Recolhimento>> getAll(){
        List<Recolhimento> recolhimentos = recolhimentoService.getAll();
        return ResponseEntity.ok().body(recolhimentos);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam String codigo, @RequestBody Recolhimento recolhimento){

        recolhimentoService.update(codigo, recolhimento);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String codigo){
        recolhimentoService.delete(codigo);
        return ResponseEntity.noContent().build();
    }
}
