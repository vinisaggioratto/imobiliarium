package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Usuarios;
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
public class InquilinoViewDTO {

    private Long id;
    private String cadastro;
    private Double salarioMensal;
    private String empresaTrabalho;
    private String funcao;
    private LocalDate dataAdmissao;
    private Integer dependentes;
    private String observacoes;
    private Boolean cadastroAtivo;
    private String usuario;

    public InquilinoViewDTO(Long id, Cadastro cadastro, Double salarioMensal, String empresaTrabalho, String funcao,
                            LocalDate dataAdmissao, Integer dependentes, String observacoes, Boolean cadastroAtivo,
                            Usuarios usuario) {
        this.id = id;
        this.cadastro = cadastro.getNome();
        this.salarioMensal = salarioMensal;
        this.empresaTrabalho = empresaTrabalho;
        this.funcao = funcao;
        this.dataAdmissao = dataAdmissao;
        this.dependentes = dependentes;
        this.observacoes = observacoes;
        this.cadastroAtivo = cadastroAtivo;
        this.usuario = usuario.getUsername();
    }
}
