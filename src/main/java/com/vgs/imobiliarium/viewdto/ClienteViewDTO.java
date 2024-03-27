package com.vgs.imobiliarium.viewdto;

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
public class ClienteViewDTO {

    private Long id;
    private String cadastro;
    private String preferencias;
    private String observacoes;
    private Boolean cadastroAtivo;
    private String usuario;

    public ClienteViewDTO(Long id, Cadastro cadastro, String preferencias, String observacoes, Boolean cadastroAtivo,
                          Usuarios usuario) {
        this.id = id;
        this.cadastro = cadastro.getNome();
        this.preferencias = preferencias;
        this.observacoes = observacoes;
        this.cadastroAtivo = cadastroAtivo;
        this.usuario = usuario.getUsername();
    }
}
