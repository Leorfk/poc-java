package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.dto.ViewPofDTO;
import com.leorfk.natureza.repository.entity.ViewPof;
import com.leorfk.natureza.repository.interfaces.jpa.ViewPofRepository;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
import com.leorfk.natureza.service.interfaces.IViewPofService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViewPofService implements IViewPofService {

    @Autowired
    private ViewPofRepository viewPofRepository;

    @Override
    public ViewPofDTO cadastrarViewPof(ViewPofDTO viewPofDTO) {
        ViewPof viewPof = fromEntity(viewPofDTO);
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
        return null;
    }

    @Override
    public ViewPofDTO deletarViewPof(Integer id) {
        return null;
    }

    @Override
    public ViewPofDTO buscarPorIdViewPof(Integer id) {
        return null;
    }

    @Override
    public List<ViewPofDTO> listarTodasViewPof() {
        return null;
    }

    private ViewPofDTO fromDTO(ViewPof viewPof){
        ViewPofDTO viewPofDTO = new ViewPofDTO
                .Builder(viewPof.getNomeProduto())
                .id(viewPof.getId())
                .nomeView(viewPof.getNomeView())
                .campoChave(viewPof.getCampoChave())
                .build();
        return viewPofDTO;
    }

    private ViewPof fromEntity(ViewPofDTO viewPofDTO){
        ViewPof entity = new ViewPof();
        entity.setId(viewPofDTO.getId());
        entity.setNomeView(viewPofDTO.getNomeView());
        entity.setCampoChave(viewPofDTO.getCampoChave());
        entity.setNomeProduto(viewPofDTO.getNomeProduto());
        return entity;
    }
}
