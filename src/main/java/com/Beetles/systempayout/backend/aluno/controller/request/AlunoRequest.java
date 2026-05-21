package com.Beetles.systempayout.backend.aluno.controller.request;

import com.Beetles.systempayout.backend.plano.model.Plano;
import com.Beetles.systempayout.backend.shared.enums.Enum_Status;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record AlunoRequest(@NotBlank
                           String nome,
                           @Nullable
                           Plano plano,
                           @Nullable
                           Enum_Status status
                           ) {
}
