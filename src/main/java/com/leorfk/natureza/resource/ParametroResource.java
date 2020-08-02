package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.service.impl.ParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/parametrizacao")
public class ParametroResource {

    @Autowired
    private ParametroService parametroService;

    @GetMapping
    public ResponseEntity<List<Parametro>> getAll(){
        List<Parametro> resp = parametroService.buscarTodos();
        return ResponseEntity.ok(resp);
    }
}
