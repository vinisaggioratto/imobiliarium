package com.vgs.imobiliarium.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;
    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;
    @Column(name = "data_cadastro", updatable=false)
    private LocalDateTime dataCadastroUser;
    @Column(name = "data_update")
    private LocalDateTime dataUpdateUser;

    public Usuarios(Long id) {
        this.id = id;
    }

    @PrePersist
    public void onPrePersist() {
        this.setDataCadastroUser(LocalDateTime.now());
        this.setDataUpdateUser(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate() {
        this.setDataUpdateUser(LocalDateTime.now());
    }
}
