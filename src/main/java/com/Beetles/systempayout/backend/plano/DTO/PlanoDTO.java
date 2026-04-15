package com.Beetles.systempayout.backend.plano.DTO;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanoDTO {
    private UUID planoId;
    private String nome;
    private Set<Aluno> alunos;
    private String categoria;
    private Integer frequenciaAulas;
    private BigDecimal valor;
    private boolean ativo;
    private LocalDate dataCriacao;
}
