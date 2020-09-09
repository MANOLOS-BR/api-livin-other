package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

  AppUser findByEmail(String email);

}
