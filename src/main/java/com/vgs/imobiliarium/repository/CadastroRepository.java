package com.vgs.imobiliarium.repository;

import com.vgs.imobiliarium.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
