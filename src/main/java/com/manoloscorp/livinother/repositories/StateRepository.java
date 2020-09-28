package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
