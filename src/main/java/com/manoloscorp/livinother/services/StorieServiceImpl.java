package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Storie;
import com.manoloscorp.livinother.repositories.StorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StorieServiceImpl implements StorieService {

  private final StorieRepository storieRepository;

  public StorieServiceImpl(StorieRepository storieRepository) {
    this.storieRepository = storieRepository;
  }

  @Override
  public List<Storie> getAllStories() {
    return storieRepository.findAll();
  }

  @Override
  public Storie saveStorie(Storie storie) {
    return storieRepository.save(storie);
  }
}
