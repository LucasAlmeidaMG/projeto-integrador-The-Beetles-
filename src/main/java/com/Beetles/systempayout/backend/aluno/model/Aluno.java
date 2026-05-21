package com.Beetles.systempayout.backend.aluno.model;

import com.Beetles.systempayout.backend.plano.model.Plano;
import com.Beetles.systempayout.backend.shared.enums.Enum_Status;
import com.Beetles.systempayout.backend.shared.enums.Enums_roles;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "planoEscolhidoId")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "aluno_id",nullable = false, unique = true)
    private UUID alunoId;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "plano_escolhido_id", nullable = true)
    private Plano planoEscolhidoId;

    private boolean primeiroAcesso;

    private Enum_Status status;

    private LocalDateTime diaVencimento;

    @Column(name = "role")
    private Enums_roles role = Enums_roles.ALUNOS;

    @CreationTimestamp
    private LocalDateTime dataInicioPlano;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @PrePersist
    public void roles(){
        if(this.role == null){
            this.role = Enums_roles.ALUNOS;
        }
    }

    public void calcularVencimento(){
        if(this.dataInicioPlano == null){
            throw new RuntimeException("O usuário não possui um plano cadastrado");
        }else{
            diaVencimento = dataInicioPlano.plusMonths(1);
        }
    }
}
