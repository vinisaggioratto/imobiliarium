package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Usuarios;
import com.vgs.imobiliarium.enums.TipoComissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComissaoDTO {

    private Long id;
    private Double percentual;
    private TipoComissao tipoComissao;
    private Boolean cadastroAtivo;
    private Usuarios usuarios;
}
