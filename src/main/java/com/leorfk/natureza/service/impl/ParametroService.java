package com.leorfk.natureza.service.impl;

import com.leorfk.natureza.domain.*;
import com.leorfk.natureza.domain.enums.Interacao;
import com.leorfk.natureza.domain.enums.StatusParametro;
import com.leorfk.natureza.dto.ParametrizacaoDTO;
import com.leorfk.natureza.repository.interfaces.IParametroRepository;
import com.leorfk.natureza.service.exception.DataIntegrityException;
import com.leorfk.natureza.service.exception.ObjectNotFoundException;
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
    public void salvarParametrizacao(ParametrizacaoDTO objDTO) {

        if (parametrizacaoNaoExiste(objDTO.getCodigoProduto(), objDTO.getCodigoRecolhimento())){
            Parametro parametro = fromDTO(objDTO);
            parametro.setStatus(StatusParametro.APROVACAO_PENDENTE);
            parametro.setInteracao(Interacao.CADASTRO.getDescricao());
            parametroRepository.salvarParametrizacao(parametro);
        }
        throw new DataIntegrityException("Parametrização já está cadastrada e ativa");
    }

    @Override
    public void alterarParametrizacao(int id, ParametrizacaoDTO objDTO) {

        if (parametrizacaoNaoExiste(objDTO.getCodigoProduto(), objDTO.getCodigoRecolhimento())){
            Parametro parametro = fromDTO(objDTO);
            parametro.setStatus(StatusParametro.APROVACAO_PENDENTE);
            parametro.setInteracao(Interacao.ALTERACAO.getDescricao());
            parametroRepository.alterarParametrizacao(id, parametro);
        }
        throw new DataIntegrityException("Parametrização já está cadastrada e ativa");
    }

    @Override
    public void aprovarParametrizacao(int id, Usuario usuario) {
    }

    @Override
    public void reprovarParametrizacao(int id, Usuario usuario) {
    }

    @Override
    public List<ParametrizacaoDTO> buscarRecentes() {
        return null;
    }

    @Override
    public List<ParametrizacaoDTO> buscarTodos() {

        List<Parametro> parametros = parametroRepository.buscarTodos();
        if (listaTemItens(parametros)){
            return  popularDTOs(parametros);
        }
        throw new ObjectNotFoundException("Nenhum registro encontrado");
    }

    @Override
    public List<ParametrizacaoDTO> buscarHistorico(int id) {
        List<Parametro> parametros = parametroRepository.buscarPorId(id);
        if (listaTemItens(parametros)){
            return popularDTOs(parametros);
        }
        throw new ObjectNotFoundException("Nenhum registro de histórico encontrado");
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

    private boolean listaTemItens(List<Parametro> parametros){
        if (parametros == null || parametros.size() == 0){
            return false;
        }
        return true;
    }

    private List<ParametrizacaoDTO> popularDTOs(List<Parametro> parametros){
        List<ParametrizacaoDTO> parametrizacaoDTOS = new ArrayList<>();

        for (Parametro parametro:parametros) {
            parametrizacaoDTOS.add(fromDomain(parametro));
        }
        return parametrizacaoDTOS;
    }

    private boolean parametrizacaoNaoExiste(String codigoProduto, String codigoRecolhimento){
        List<Parametro> parametros = parametroRepository.buscarProdutoRecolhimento(codigoProduto, codigoRecolhimento);
        if (parametros != null){
            for (Parametro parametro: parametros) {
                if (parametro.getStatus() == StatusParametro.APROVADO ||
                        parametro.getStatus() == StatusParametro.APROVACAO_PENDENTE){
                    return false;
                }
            }
        }
        return true;
    }
}
