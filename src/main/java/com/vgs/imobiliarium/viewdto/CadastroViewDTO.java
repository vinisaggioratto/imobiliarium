package com.vgs.imobiliarium.viewdto;

import com.vgs.imobiliarium.enums.Estado;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CadastroViewDTO {

    private Long id;
    private String nome;
    private String cpfCnpj;
    private String rg;
    private LocalDate dataNascimento;
    private String email;
    private String telefoneCelular;
    private String sexo;
    private Boolean cadastroAtivo;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private Estado estado;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataUpdate;

    public CadastroViewDTO(Long id, String nome, String cpfCnpj, String rg, LocalDate dataNascimento,
                           String email, String telefoneCelular, String sexo, Boolean cadastroAtivo, String rua,
                           int numero, String bairro, String cidade, String cep, Estado estado,
                           LocalDateTime dataCadastro, LocalDateTime dataUpdate) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.sexo = sexo;
        this.cadastroAtivo = cadastroAtivo;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.dataCadastro = dataCadastro;
        this.dataUpdate = dataUpdate;
    }
}
