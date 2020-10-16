package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String useremail);
  Long countUserByUserType(UserType value);
  Boolean existsUserByEmail(String useremail);
  Boolean existsUserById(Long id);

}
