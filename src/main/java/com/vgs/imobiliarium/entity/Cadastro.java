package com.vgs.imobiliarium.entity;

import com.vgs.imobiliarium.enums.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    private String rg;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    private String email;
    @Column(name = "telefone_celular")
    private String telefoneCelular;
    private String sexo;
    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private Estado estado;
    @Column(name = "data_cadastro", updatable=false)
    private LocalDateTime dataCadastro;
    @Column(name = "data_update")
    private LocalDateTime dataUpdate;

    public Cadastro(Long id) {
        this.id = id;
    }

    @PrePersist
    public void onPrePersist(){
        this.setDataCadastro(LocalDateTime.now());
        this.setDataUpdate(LocalDateTime.now());
    }
    @PreUpdate
    public void onPreUpdate(){
        this.setDataUpdate(LocalDateTime.now());
    }

}
