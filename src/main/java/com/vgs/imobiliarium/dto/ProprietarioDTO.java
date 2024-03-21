package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProprietarioDTO {

    private Long id;
    private Cadastro cadastro;
    private Boolean cadastroAtivo;
    private Usuarios usuario;
}
