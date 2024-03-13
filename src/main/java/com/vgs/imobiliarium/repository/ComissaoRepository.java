package com.vgs.imobiliarium.repository;

import com.vgs.imobiliarium.entity.Comissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComissaoRepository extends JpaRepository<Comissao, Long> {
}
