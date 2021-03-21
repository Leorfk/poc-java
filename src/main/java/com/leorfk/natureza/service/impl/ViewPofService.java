package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.dto.ViewPofDTO;
import com.leorfk.natureza.repository.entity.ViewPof;
import com.leorfk.natureza.repository.interfaces.jpa.ViewPofRepository;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
import com.leorfk.natureza.service.interfaces.IViewPofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViewPofService implements IViewPofService {

    @Autowired
    private ViewPofRepository viewPofRepository;

    @Override
    public ViewPofDTO cadastrarViewPof(ViewPofDTO viewPofDTO) {
        ViewPof viewPof = toEntity(viewPofDTO);
        viewPofRepository.save(viewPof);

        Optional<ViewPof> response = viewPofRepository.findByNomeProduto(viewPof.getNomeProduto());
        if (response.isPresent()){
            viewPofDTO.setId(response.get().getId());
            return viewPofDTO;
        } else {
          throw new ObjectNotFoundException("Houve um erro, view não cadastrada");
        }
    }

    @Override
    public ViewPofDTO atualizarViewPof(Integer id, ViewPofDTO viewPofDTO) {
        if (viewPofRepository.existsById(id)){
            viewPofDTO.setId(id);
            ViewPof viewPof = toEntity(viewPofDTO);
            viewPofRepository.save(viewPof);
            return viewPofDTO;
        } else {
            throw new ObjectNotFoundException("Evento não encontrado");
        }
    }

    @Override
    public void deletarViewPof(Integer id) {
        if (viewPofRepository.existsById(id)){
            viewPofRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException("Evento inexistente");
        }
    }

    @Override
    public ViewPofDTO buscarViewPofPorId(Integer id) {
        Optional<ViewPof> viewPof = viewPofRepository.findById(id);
        if (viewPof.isPresent()){
            return toDTO(viewPof.get());
        } else {
            throw new ObjectNotFoundException("Evento não encontrado");
        }
    }

    @Override
    public List<ViewPofDTO> listarTodasViewPof() {
        Iterable<ViewPof> pofs = viewPofRepository.findAll();
        List<ViewPofDTO> dtos = new ArrayList<>();
        pofs.forEach(x -> dtos.add(toDTO(x)));
        if (dtos.size() > 0){
            return dtos;
        } else {
            throw new ObjectNotFoundException("Nenhum evento cadastrado");
        }
    }

    private ViewPofDTO toDTO(ViewPof viewPof){
        return new ViewPofDTO
                .Builder(viewPof.getNomeProduto())
                .id(viewPof.getId())
                .nomeView(viewPof.getNomeView())
                .campoChave(viewPof.getCampoChave())
                .build();
    }

    private ViewPof toEntity(ViewPofDTO viewPofDTO){
        ViewPof entity = new ViewPof();
        entity.setId(viewPofDTO.getId());
        entity.setNomeView(viewPofDTO.getNomeView());
        entity.setCampoChave(viewPofDTO.getCampoChave());
        entity.setNomeProduto(viewPofDTO.getNomeProduto());
        return entity;
    }
}
