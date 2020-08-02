package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.repository.impl.ParametroRepository;
import com.leorfk.natureza.service.interfaces.IParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ParametroService implements IParametroService {

    @Autowired
    private ParametroRepository parametroRepository;

    @Override
    public String salvarParametrizacao(Parametro parametro) {
        return null;
    }

    @Override
    public String alterarParametrizacao(int id, Parametro parametro) {
        return null;
    }

    @Override
    public String aprovarParametrizacao(int id, Usuario usuario) {
        return null;
    }

    @Override
    public String reprovarParametrizacao(int id, Usuario usuario) {
        return null;
    }

    @Override
    public Parametro buscarRecentes() {
        return null;
    }

    @Override
    public List<Parametro> buscarTodos() {
        return parametroRepository.buscarTodos();
    }

    @Override
    public Parametro buscarPorId() {
        return null;
    }
}
