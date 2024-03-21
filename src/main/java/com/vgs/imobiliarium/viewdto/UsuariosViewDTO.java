package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Cadastro;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UsuariosViewDTO {

    private Long id;
    private String username;
    private String cadastro;
    private Boolean cadastroAtivo;

    public UsuariosViewDTO(Long id, String username, Cadastro cadastro, Boolean cadastroAtivo) {
        this.id = id;
        this.username = username;
        this.cadastro = cadastro.getNome();
        this.cadastroAtivo = cadastroAtivo;

    }
}
