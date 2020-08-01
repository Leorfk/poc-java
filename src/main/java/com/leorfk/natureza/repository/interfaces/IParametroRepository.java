package com.leorfk.natureza.repository.interfaces;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;

public interface IParametroRepository {
    String salvarParametrizacao(Parametro parametro);
    String alterarParametrizacao(int id, Parametro parametro);
    String aprovarParametrizacao(int id, Usuario usuario);
    String reprovarParametrizacao(int id, Usuario usuario);
}
