package com.leorfk.natureza.service;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.dto.ParametrizacaoDTO;
import com.leorfk.natureza.repository.impl.ParametroRepository;
import com.leorfk.natureza.service.exception.DataIntegrityException;
import com.leorfk.natureza.service.impl.ParametroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ParametrizacaoServiceTest {

    @Mock
    private ParametroRepository parametroRepository;

    @InjectMocks
    private ParametroService parametroService;

    @Test
    public void salvarParametrizacao_parametroCadastrado(){
        ParametrizacaoDTO parametro = new ParametrizacaoDTO();
        Parametro obj = parametroService.fromDTO(parametro);
        parametroService.salvarParametrizacao(parametro);
        verify(parametroRepository, times(1)).salvarParametrizacao(obj);
    }

    @Test(expected = DataIntegrityException.class)
    public void salvarParametrizacao_parametroExiste(){
        ParametrizacaoDTO parametrizacaoDTO = new ParametrizacaoDTO();
        parametroService.salvarParametrizacao(parametrizacaoDTO);
    }
}
