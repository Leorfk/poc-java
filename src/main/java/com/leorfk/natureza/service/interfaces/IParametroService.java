package com.leorfk.natureza.service.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;

import java.util.List;

public interface IParametroService {
    String salvarParametrizacao(Parametro parametro);
    String alterarParametrizacao(int id, Parametro parametro);
    String aprovarParametrizacao(int id, Usuario usuario);
    String reprovarParametrizacao(int id, Usuario usuario);
    Parametro buscarRecentes();
    List<Parametro> buscarTodos();
    Parametro buscarPorId();
}
