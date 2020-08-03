package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.dto.ParametrizacaoDTO;

import java.util.List;

public interface IParametroService {
    String salvarParametrizacao(ParametrizacaoDTO objDTO);
    String alterarParametrizacao(int id, ParametrizacaoDTO objDTO);
    String aprovarParametrizacao(int id, Usuario usuario);
    String reprovarParametrizacao(int id, Usuario usuario);
    List<ParametrizacaoDTO> buscarRecentes(int id);
    List<ParametrizacaoDTO> buscarTodos();
    List<ParametrizacaoDTO> buscarHistorico(int id);

}
