package com.Beetles.systempayout.backend.plano.model;

import com.Beetles.systempayout.backend.aluno.model.Aluno;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "planos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Planos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "plano_id")
    private Integer planoId;
    @Column(nullable = false)
    private String nome;
    @OneToMany(mappedBy = "planoEscolhidoId",fetch = FetchType.LAZY)
    private Set<Aluno> alunos;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private Integer frequenciaAulas;
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;
    private boolean ativo;
    @Column(updatable = false)
    private LocalDate dataCriacao;
}
