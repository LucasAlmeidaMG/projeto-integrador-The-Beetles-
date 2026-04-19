package com.Beetles.systempayout.backend.historico.controller.Request;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import lombok.Builder;

@Builder
public record HistoricoRequest(Aluno aluno) {
}
