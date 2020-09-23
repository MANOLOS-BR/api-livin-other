package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.Ischemia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IschemiaRepository extends JpaRepository<Ischemia, Long>{

}
