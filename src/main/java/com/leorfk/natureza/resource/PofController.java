package com.leorfk.natureza.resource;

import com.leorfk.natureza.dto.ViewPofDTO;
import com.leorfk.natureza.repository.impl.BasePofRepository;
import com.leorfk.natureza.service.impl.ViewPofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/pofs")
public class PofController {

    @Autowired
    private ViewPofService viewPofService;

    @PostMapping()
    public ResponseEntity<ViewPofDTO> cadastrarView(@RequestBody ViewPofDTO viewPofDTO){
        ViewPofDTO response = viewPofService.cadastrarViewPof(viewPofDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viewPofDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

//    @Autowired
//    private BasePofRepository basePofRepository;
//
//    @GetMapping("pof")
//    public ResponseEntity extractPof(){
//        basePofRepository.selectBasePof();
//        return ResponseEntity.notFound().build();
//    }
}
