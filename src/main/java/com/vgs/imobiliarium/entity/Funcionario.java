package com.vgs.imobiliarium.entity;

import com.vgs.imobiliarium.enums.Funcao;
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
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;
    private Double salario;
    @ManyToOne
    @JoinColumn(name = "comissao_id")
    private Comissao comissao;
    private Funcao funcao;
    private LocalDate data_admissao;
    private LocalDate data_demissao;
    private Boolean cadastro_ativo;
    @Column(name = "data_cadastro", updatable = false)
    private LocalDateTime dataCadastroFuncionario;
    @Column(name = "data_update")
    private LocalDateTime dataUpdateFuncionario;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Funcionario(Long id) {
        this.id = id;
    }
}
