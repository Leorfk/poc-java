package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.*;
import com.leorfk.natureza.domain.enums.Interacao;
import com.leorfk.natureza.domain.enums.StatusParametro;
import com.leorfk.natureza.dto.ParametrizacaoDTO;
import com.leorfk.natureza.repository.interfaces.IParametroRepository;
import com.leorfk.natureza.service.interfaces.IParametroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ParametroService implements IParametroService {

    @Autowired
    private IParametroRepository parametroRepository;

    @Override
    public String salvarParametrizacao(ParametrizacaoDTO objDTO) {
        Parametro parametro = fromDTO(objDTO);
        parametro.setStatus(StatusParametro.APROVACAO_PENDENTE);
        parametro.setInteracao(Interacao.CADASTRO.getDescricao());
        if(parametroRepository.salvarParametrizacao(parametro) != 0){
            return "Parametrização realizada com sucesso";
        }
        return "Erro";
    }

    @Override
    public String alterarParametrizacao(int id, ParametrizacaoDTO objDTO) {
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
    public List<ParametrizacaoDTO> buscarRecentes(int id) {
        return null;
    }

    @Override
    public List<ParametrizacaoDTO> buscarTodos() {
        List<ParametrizacaoDTO> parametrizacaoDTOS = new ArrayList<>();
        List<Parametro> parametros = parametroRepository.buscarTodos();

        for (Parametro parametro:parametros) {
            parametrizacaoDTOS.add(fromDomain(parametro));
        }
        return parametrizacaoDTOS;
    }

    @Override
    public List<ParametrizacaoDTO> buscarHistorico(int id) {
        return null;
    }

    private Parametro fromDTO(ParametrizacaoDTO objDTO){
        Parametro parametro = new Parametro();
        Natureza natureza = new Natureza();
        Recolhimento recolhimento = new Recolhimento();
        Produto produto = new Produto();
        Usuario usuario = new Usuario();

        natureza.setDescricao(objDTO.getDescricaoNatureza());
        natureza.setCodigo(objDTO.getCodigoNatureza());

        recolhimento.setDescricao(objDTO.getDescricaoRecolhimento());
        recolhimento.setCodigo(objDTO.getCodigoRecolhimento());

        produto.setDescricao(objDTO.getDescricaoProduto());
        produto.setCodigo(objDTO.getCodigoProduto());
        produto.setSigla(objDTO.getSigla());

        usuario.setMotivo(objDTO.getMotivo());
        usuario.setRacf(objDTO.getRaf());

        parametro.setId(objDTO.getId());
        parametro.setData(objDTO.getData());
        parametro.setInteracao(objDTO.getInteracao());
        parametro.setNatureza(natureza);
        parametro.setRecolhimento(recolhimento);
        parametro.setProduto(produto);
        parametro.setUsuario(usuario);

        return parametro;
    }

    private ParametrizacaoDTO fromDomain(Parametro parametro){
        ParametrizacaoDTO parametrizacaoDTO = new ParametrizacaoDTO();
        parametrizacaoDTO.setId(parametro.getId());
        parametrizacaoDTO.setData(parametro.getData());
        parametrizacaoDTO.setInteracao(parametro.getInteracao());
        parametrizacaoDTO.setStatus(parametro.getStatus().getCodigo());
        parametrizacaoDTO.setMotivo(parametro.getUsuario().getMotivo());

        parametrizacaoDTO.setRaf(parametro.getUsuario().getRacf());

        parametrizacaoDTO.setSigla(parametro.getProduto().getSigla());
        parametrizacaoDTO.setCodigoProduto(parametro.getProduto().getCodigo());
        parametrizacaoDTO.setDescricaoProduto(parametro.getProduto().getDescricao());

        parametrizacaoDTO.setCodigoNatureza(parametro.getNatureza().getCodigo());
        parametrizacaoDTO.setDescricaoNatureza(parametro.getNatureza().getDescricao());

        parametrizacaoDTO.setCodigoRecolhimento(parametro.getRecolhimento().getCodigo());
        parametrizacaoDTO.setDescricaoRecolhimento(parametro.getRecolhimento().getDescricao());

        return parametrizacaoDTO;
    }
}
