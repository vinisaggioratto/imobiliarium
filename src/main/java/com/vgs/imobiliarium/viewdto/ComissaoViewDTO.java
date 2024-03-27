package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Usuarios;
import com.vgs.imobiliarium.enums.TipoComissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComissaoViewDTO {

    private Long id;
    private Double percentual;
    private String tipoComissao;
    private Boolean cadastroAtivo;
    private String usuario;

    public ComissaoViewDTO(Long id, Double percentual, TipoComissao tipoComissao, Boolean cadastroAtivo, Usuarios usuario) {
        this.id = id;
        this.percentual = percentual;
        this.tipoComissao = tipoComissao.name();
        this.cadastroAtivo = cadastroAtivo;
        this.usuario = "Cadastrado por: " + usuario.getUsername();
    }
}
