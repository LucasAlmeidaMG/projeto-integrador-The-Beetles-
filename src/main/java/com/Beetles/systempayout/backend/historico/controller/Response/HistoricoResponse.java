package com.Beetles.systempayout.backend.historico.controller.Response;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record HistoricoResponse(Aluno aluno,
                                BigDecimal valorCobrado,
                                String statusPagamento,
                                LocalDateTime dataSolicitacao,
                                LocalDateTime dataConfirmacao) {
}
