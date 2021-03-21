package com.leorfk.natureza.resource;

import com.leorfk.natureza.dto.ViewPofDTO;
import com.leorfk.natureza.repository.impl.BasePofRepository;
import com.leorfk.natureza.service.impl.ViewPofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/pofs")
public class PofController {

    @Autowired
    private ViewPofService viewPofService;

    @GetMapping("{id}")
    public ResponseEntity<ViewPofDTO> buscarPofPorId(@RequestParam Integer id){
        ViewPofDTO response = viewPofService.buscarViewPofPorId(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping()
    public ResponseEntity<List<ViewPofDTO>> listarPofs(){
        return ResponseEntity.ok().body(viewPofService.listarTodasViewPof());
    }

    @PostMapping()
    public ResponseEntity<ViewPofDTO> cadastrarView(@RequestBody ViewPofDTO viewPofDTO){
        ViewPofDTO response = viewPofService.cadastrarViewPof(viewPofDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(viewPofDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<ViewPofDTO> atualizarViewPof(@RequestParam Integer id, @RequestBody ViewPofDTO viewPofDTO){
        ViewPofDTO response = viewPofService.atualizarViewPof(id, viewPofDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(viewPofDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarPof(Integer id){
        viewPofService.deletarViewPof(id);
        return ResponseEntity.noContent().build();
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
