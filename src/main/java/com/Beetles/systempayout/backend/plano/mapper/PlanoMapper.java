package com.Beetles.systempayout.backend.plano.mapper;

import com.Beetles.systempayout.backend.plano.DTO.PlanoDTO;
import com.Beetles.systempayout.backend.plano.model.Plano;
import org.springframework.stereotype.Component;

@Component
public class PlanoMapper {
    public Plano map(PlanoDTO planoDTO){
        Plano plano = new Plano();
        plano.setPlanoId(planoDTO.getPlanoId());
        plano.setCategoria(planoDTO.getCategoria());
        plano.setNome(planoDTO.getNome());
        plano.setAlunos(planoDTO.getAlunos());
        plano.setAtivo(planoDTO.isAtivo());
        plano.setValor(planoDTO.getValor());
        plano.setFrequenciaAulas(planoDTO.getFrequenciaAulas());
        plano.setDataCriacao(planoDTO.getDataCriacao());
        return plano;
    }

    public PlanoDTO map(Plano plano){
        PlanoDTO planoDTO = new PlanoDTO();
        planoDTO.setPlanoId(plano.getPlanoId());
        planoDTO.setAlunos(plano.getAlunos());
        planoDTO.setAtivo(planoDTO.isAtivo());
        planoDTO.setCategoria(plano.getCategoria());
        planoDTO.setNome(plano.getNome());
        planoDTO.setDataCriacao(plano.getDataCriacao());
        planoDTO.setValor(plano.getValor());
        planoDTO.setFrequenciaAulas(plano.getFrequenciaAulas());
        return planoDTO;
    }
}
