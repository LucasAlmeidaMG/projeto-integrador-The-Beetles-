package com.Beetles.systempayout.backend.aluno.DTO;

import com.Beetles.systempayout.backend.plano.model.Planos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlunoDTO {
    private String telefone;
    private String nome;
    private Planos planoEscolhidoId;
    private String status;
    private LocalDateTime dataCadastro;
    private boolean primeiroAcesso;
    private LocalDateTime diaVencimento;
    private LocalDateTime dataProximoVencimento;
    private LocalDateTime dataInicioPlano;
}
