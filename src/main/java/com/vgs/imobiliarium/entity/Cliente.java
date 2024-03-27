package com.vgs.imobiliarium.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;
    private String preferencias;
    private String observacoes;
    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Cliente(Long id) {
        this.id = id;
    }
}
