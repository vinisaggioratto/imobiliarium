package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Cadastro;
import com.vgs.imobiliarium.entity.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProprietarioViewDTO {

    private Long id;
    private String cadastro;
    private Boolean cadastroAtivo;
    private String usuario;

    public ProprietarioViewDTO(Long id, Cadastro cadastro, Boolean cadastroAtivo, Usuarios usuario){
        this.id = id;
        this.cadastro = cadastro.getNome();
        this.cadastroAtivo = cadastroAtivo;
        this.usuario = "Cadastrado por: " + usuario.getUsername();
    }


}
