package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.dto.ParametrizacaoDTO;

import java.util.List;

public interface IParametroService {
    void salvarParametrizacao(ParametrizacaoDTO objDTO);
    void alterarParametrizacao(int id, ParametrizacaoDTO objDTO);
    void aprovarParametrizacao(int id, Usuario usuario);
    void reprovarParametrizacao(int id, Usuario usuario);
    List<ParametrizacaoDTO> buscarRecentes();
    List<ParametrizacaoDTO> buscarTodos();
    List<ParametrizacaoDTO> buscarHistorico(int id);

}
