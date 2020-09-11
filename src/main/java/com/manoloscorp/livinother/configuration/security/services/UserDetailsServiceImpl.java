package com.manoloscorp.livinother.configuration.security.services;


import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(useremail)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + useremail));

    return UserDetailsImpl.build(user);
  }

}
