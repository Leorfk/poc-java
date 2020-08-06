package com.leorfk.natureza.resource;

import com.leorfk.natureza.domain.Natureza;
import com.leorfk.natureza.dto.ParametrizacaoDTO;
import com.leorfk.natureza.service.interfaces.IParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/parametrizacao")
public class ParametrizacaoController {

    @Autowired
    private IParametroService parametroService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ParametrizacaoDTO objDTO){
        parametroService.salvarParametrizacao(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("natureza?id={id}").buildAndExpand(objDTO.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam int id, @RequestBody ParametrizacaoDTO objDTO){
        parametroService.alterarParametrizacao(id, objDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ParametrizacaoDTO>> getAll(){
        List<ParametrizacaoDTO> parametrizacaoDTOS = parametroService.buscarTodos();
        return ResponseEntity.ok().body(parametrizacaoDTOS);
    }

    @GetMapping
    public ResponseEntity<List<ParametrizacaoDTO>> getById(@RequestParam int id){
        List<ParametrizacaoDTO> parametrizacaoDTOS = parametroService.buscarHistorico(id);
        return ResponseEntity.ok().body(parametrizacaoDTOS);
    }
}
