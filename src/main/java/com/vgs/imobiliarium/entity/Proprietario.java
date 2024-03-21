package com.vgs.imobiliarium.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "proprietario")
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Proprietario(Long id) {
        this.id = id;
    }
}
