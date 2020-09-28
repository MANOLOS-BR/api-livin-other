package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganRepository extends JpaRepository<Organ, Long> {
}
