package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String useremail);
  Boolean existsUserByEmail(String useremail);
  Boolean existsUserById(Long id);
}
