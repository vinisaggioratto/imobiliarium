package com.vgs.imobiliarium.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "corretor")
public class Corretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

    @Column(name = "numero_registro")
    private String numeroRegistro;

    @ManyToOne
    @JoinColumn(name = "comissao_id")
    private Comissao comissao;

    private String especialidade;

    @Column(name = "cadastro_ativo")
    private Boolean cadastroAtivo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuario;

    public Corretor(Long id) {
        this.id = id;
    }
}
