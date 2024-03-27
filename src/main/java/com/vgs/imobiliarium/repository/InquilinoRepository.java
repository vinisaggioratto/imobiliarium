package com.vgs.imobiliarium.repository;

import com.vgs.imobiliarium.entity.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Long> {
}
