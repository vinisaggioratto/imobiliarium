package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.entity.Cadastro;
import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDTO {

    private Long id;
    @Column(length = 100)
    private String username;
    @Column(length = 80)
    private String password;
    private Cadastro cadastro;
    private Boolean cadastroAtivo;
}
