package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Storie;
import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.repositories.StorieRepository;
import com.manoloscorp.livinother.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StorieServiceImpl implements StorieService {

  private final StorieRepository storieRepository;
  private final UserRepository userRepository;

  public StorieServiceImpl(StorieRepository storieRepository, UserRepository userRepository) {
    this.storieRepository = storieRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<Storie> getAllStories() {
    return storieRepository.findAll();
  }


  @Override
  public User saveStorie(User user) {
    return userRepository.save(user);
  }
}
