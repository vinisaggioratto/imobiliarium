package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Comissao;
import com.vgs.imobiliarium.entity.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CorretorViewDTO {

    private Long id;
    private String cadastro;
    private String numeroRegistro;
    private Double comissao;
    private String especialidade;
    private Boolean cadastroAtivo;
    private String usuario;

    public CorretorViewDTO(Long id, Cadastro cadastro, String numeroRegistro, Comissao comissao, String especialidade,
                           Boolean cadastroAtivo, Usuarios usuario) {
        this.id = id;
        this.cadastro = cadastro.getNome();
        this.numeroRegistro = numeroRegistro;
        this.comissao = comissao.getPercentual();
        this.especialidade = especialidade;
        this.cadastroAtivo = cadastroAtivo;
        this.usuario = usuario.getUsername();
    }
}
