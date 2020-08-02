package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.service.interfaces.INaturezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/natureza")
public class NaturezaController {

    @Autowired
    private INaturezaService naturezaService;

    @GetMapping("{id}")
    public ResponseEntity<Natureza> getById(@PathVariable("id") Integer id){
        Natureza natureza = naturezaService.getById(id);
        return new ResponseEntity<Natureza>(natureza, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Natureza natureza){
        boolean mamou = naturezaService.add(natureza);
            return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
