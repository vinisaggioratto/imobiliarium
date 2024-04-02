package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Comissao;
import com.vgs.imobiliarium.entity.Usuarios;
import com.vgs.imobiliarium.enums.Funcao;
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
public class FuncionarioDTO {

    private Long id;
    private Cadastro cadastro;
    private Double salario;
    private Comissao comissao;
    private Funcao funcao;
    private LocalDate data_admissao;
    private LocalDate data_demissao;
    private Boolean cadastro_ativo;
    private LocalDateTime dataCadastroFuncionario;
    private LocalDateTime dataUpdateFuncionario;
    private Usuarios usuario;
}
