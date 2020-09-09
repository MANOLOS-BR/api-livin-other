package com.manoloscorp.livinother.configuration.security.jwt;


import com.manoloscorp.livinother.entities.AppUser;
import com.manoloscorp.livinother.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public JwtUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser = userRepository.findByEmail(username);
    if (appUser == null) {
      throw new UsernameNotFoundException(username);
    }
    return new User(appUser.getEmail(), appUser.getPassword(), Collections.emptyList());
  }
}
