package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.AppUser;
import com.manoloscorp.livinother.repositories.UserRepository;
import com.manoloscorp.livinother.shared.exceptions.NotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<AppUser> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public AppUser getUserById(Long id) {
    Optional<AppUser> user = userRepository.findById(id);
    return user.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public UserDetails findByEmail(String useremail) throws UsernameNotFoundException {
    AppUser applicationUser = userRepository.findByEmail(useremail);
    if (applicationUser == null) {
      throw new UsernameNotFoundException(useremail);
    }
    return new User(applicationUser.getEmail(), applicationUser.getPassword(), emptyList());
  }

  @Override
  public AppUser saveUser(AppUser appUser) {
    String hashedPassword = new BCryptPasswordEncoder().encode(appUser.getPassword());
    appUser.setPassword(hashedPassword);
    return userRepository.save(appUser);
  }

  @Override
  public AppUser updateUser(Long id, AppUser appUser) {
    Optional<AppUser> productUpdate = userRepository.findById(id);
    if (productUpdate != null) {
      appUser.setId(productUpdate.get().getId());
      userRepository.save(appUser);
      return appUser;
    }
    return null;
  }

}
