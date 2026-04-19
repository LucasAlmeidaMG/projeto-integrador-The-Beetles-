package com.Beetles.systempayout.backend.historico.controller.Mapper;

import com.Beetles.systempayout.backend.historico.controller.Request.HistoricoRequest;
import com.Beetles.systempayout.backend.historico.controller.Response.HistoricoResponse;
import com.Beetles.systempayout.backend.historico.model.Historico;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HistoricoMapper {

    public static Historico mapRequest(HistoricoRequest request){

        return Historico
                .builder()
                .aluno(request.aluno())
                .build();
    }

    public static HistoricoResponse mapResponse(Historico historico){

        return HistoricoResponse
                .builder()
                .aluno(historico.getAluno())
                .valorCobrado(historico.getValorCobrado())
                .dataSolicitacao(historico.getDataSolicitacao())
                .dataConfirmacao(historico.getDataConfirmacao())
                .build();
    }
}
