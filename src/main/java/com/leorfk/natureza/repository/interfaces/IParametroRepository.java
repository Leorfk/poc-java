package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;

import java.util.List;

public interface IParametroRepository {
    int salvarParametrizacao(Parametro parametro);
    int alterarParametrizacao(int id, Parametro parametro);
    int aprovarParametrizacao(int id, Usuario usuario);
    int reprovarParametrizacao(int id, Usuario usuario);
    Parametro buscarRecentes();
    List<Parametro> buscarTodos();
    List<Parametro> buscarPorId(int id);
    Parametro buscarProdutoRecolhimento(String produto, String recolhimento);
}
