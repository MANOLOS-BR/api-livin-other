package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.Storie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorieRepository extends JpaRepository<Storie, Long> {
}
