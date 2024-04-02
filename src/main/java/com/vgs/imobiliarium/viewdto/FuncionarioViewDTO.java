package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Comissao;
import com.vgs.imobiliarium.entity.Usuarios;
import com.vgs.imobiliarium.enums.Funcao;
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
public class FuncionarioViewDTO {

    private Long id;
    private String cadastro;
    private Double salario;
    private Funcao funcao;
    private LocalDate data_admissao;
    private LocalDate data_demissao;
    private Boolean cadastro_ativo;
    private String usuario;

    public FuncionarioViewDTO(Long id, Cadastro cadastro, Double salario, Funcao funcao,
                              LocalDate data_admissao, LocalDate data_demissao, Boolean cadastro_ativo,
                              Usuarios usuario) {
        this.id = id;
        this.cadastro = cadastro.getNome();
        this.salario = salario;
        this.funcao = funcao;
        this.data_admissao = data_admissao;
        this.data_demissao = data_demissao;
        this.cadastro_ativo = cadastro_ativo;
        this.usuario = usuario.getUsername();
    }
}
