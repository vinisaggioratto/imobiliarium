package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Cliente;
import com.vgs.imobiliarium.entity.Usuarios;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InquilinoDTO {

    private Long id;
    private Cadastro cadastro;
    private Double salarioMensal;
    @Column(length = 100, nullable = false)
    private String empresaTrabalho;
    @Column(length = 100, nullable = false)
    private String funcao;
    private LocalDate dataAdmissao;
    private Integer dependentes;
    @Column(length = 1000)
    private String observacoes;
    private Boolean cadastroAtivo;
    private LocalDateTime dataCadastroInquilino;
    private LocalDateTime dataUpdateInquilino;
    private Usuarios usuario;
}
