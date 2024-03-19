package com.vgs.imobiliarium.dto;

import com.vgs.imobiliarium.enums.Estado;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CadastroDTO {
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 20, nullable = false, unique = true)
    private String cpfCnpj;
    @Column(length = 30)
    private String rg;
    private LocalDate dataNascimento;
    @Email
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 15, nullable = false)
    private String telefoneCelular;
    @Column(length = 10, nullable = false)
    private String sexo;
    private Boolean cadastroAtivo;
    @Column(length = 100)
    private String rua;
    private int numero;
    @Column(length = 50)
    private String bairro;
    @Column(length = 80)
    private String cidade;
    @Column(length = 10)
    private String cep;
    @Column(length = 2)
    private Estado estado;
    //private LocalDateTime dataCadastro;
    //private LocalDateTime dataUpdate;

}
