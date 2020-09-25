package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.Transplant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransplantRepository extends JpaRepository<Transplant, Long> {
}
