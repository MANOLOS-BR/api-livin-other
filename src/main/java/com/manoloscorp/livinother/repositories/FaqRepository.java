package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
}
