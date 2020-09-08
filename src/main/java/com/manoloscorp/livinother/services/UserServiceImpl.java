package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.repositories.UserRepository;
import com.manoloscorp.livinother.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
    Optional<User> user = userRepository.findById(id);
    return user.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(Long id, User user) {
    Optional<User> productUpdate = userRepository.findById(id);
    if (productUpdate != null) {
      user.setId(productUpdate.get().getId());
      userRepository.save(user);
      return user;
    }
    return null;
  }

}
