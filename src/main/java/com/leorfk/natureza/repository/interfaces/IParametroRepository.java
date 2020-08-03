package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;

import java.util.List;

public interface IParametroRepository {
    int salvarParametrizacao(Parametro parametro);
    boolean alterarParametrizacao(int id, Parametro parametro);
    boolean aprovarParametrizacao(int id, Usuario usuario);
    boolean reprovarParametrizacao(int id, Usuario usuario);
    Parametro buscarRecentes();
    List<Parametro> buscarTodos();
    Parametro buscarPorId();
}
