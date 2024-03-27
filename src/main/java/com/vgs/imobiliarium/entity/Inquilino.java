package com.vgs.imobiliarium.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "inquilino")
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;
    @Column(name = "salario_mensal")
    private Double salarioMensal;
    @Column(name = "empresa_trabalho")
    private String empresaTrabalho;
    private String funcao;
    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;
    private Integer dependentes;
    private String observacoes;
    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;
    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastroInquilino;
    @Column(name = "data_update")
    private LocalDateTime dataUpdateInquilino;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Inquilino(Long id) {
        this.id = id;
    }

}
