package com.leorfk.natureza.repository.emp;

import com.leorfk.natureza.domain.Parametro;
import com.leorfk.natureza.domain.Usuario;
import com.leorfk.natureza.repository.interfaces.IParametroRepository;

public class ParametroRepository implements IParametroRepository {
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
}
