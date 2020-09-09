package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.AppUser;
import com.manoloscorp.livinother.shared.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

  List<AppUser> getAllUsers();

  AppUser getUserById(Long id) throws NotFoundException;

  UserDetails findByEmail(String email);

  AppUser saveUser(AppUser appUser);

  AppUser updateUser(Long id, AppUser appUser);

}
