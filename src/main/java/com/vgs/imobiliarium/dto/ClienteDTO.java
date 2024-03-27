package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Usuarios;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private Cadastro cadastro;
    @Column(length = 2000, nullable = false)
    private String preferencias;
    @Column(length = 1000)
    private String observacoes;
    private Boolean cadastroAtivo;
    private Usuarios usuario;
}
