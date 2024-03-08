package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.entity.Cadastro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UsuariosViewDTO {

    private Long id;
    private String username;
    private String cadastro;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUpdate;

    public UsuariosViewDTO(Long id, String username, Cadastro cadastro, LocalDateTime dataCadastro,
                           LocalDateTime dataUpdate) {
        this.id = id;
        this.username = username;
        this.cadastro = cadastro.getNome() + " " + cadastro.getSobrenome();
        this.dataCadastro = dataCadastro;
        this.dataUpdate = dataUpdate;
    }
}
