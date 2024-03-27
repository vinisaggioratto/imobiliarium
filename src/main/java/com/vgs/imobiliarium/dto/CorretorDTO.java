package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Comissao;
import com.vgs.imobiliarium.entity.Usuarios;
import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CorretorDTO {


    private Long id;
    private Cadastro cadastro;

    @Column(length = 20, nullable = false)
    private String numeroRegistro;

    private Comissao comissao;

    @Column(length = 500)
    private String especialidade;

    private Boolean cadastroAtivo;

    private Usuarios usuario;
}
