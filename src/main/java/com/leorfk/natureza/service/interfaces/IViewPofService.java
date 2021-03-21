package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.dto.ViewPofDTO;
import com.leorfk.natureza.repository.entity.ViewPof;

import java.util.List;

public interface IViewPofService {

    ViewPofDTO cadastrarViewPof(ViewPofDTO viewPofDTO);
    ViewPofDTO atualizarViewPof(Integer id, ViewPofDTO viewPofDTO);
    void deletarViewPof(Integer id);
     ViewPofDTO buscarViewPofPorId(Integer id);
    List<ViewPofDTO> listarTodasViewPof();
}
