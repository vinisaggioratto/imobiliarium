package com.vgs.imobiliarium.entity;

import com.vgs.imobiliarium.enums.TipoComissao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "comissao")
public class Comissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percentual;
    @Column(name = "tipo_comissao")
    private TipoComissao tipoComissao;

    private Boolean cadastroAtivo;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuarios;

    public Comissao(Long id) {
        this.id = id;
    }
}
