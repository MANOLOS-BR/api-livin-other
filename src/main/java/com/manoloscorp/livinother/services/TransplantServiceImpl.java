package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Transplant;
import com.manoloscorp.livinother.repositories.TransplantRepository;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransplantServiceImpl implements TransplantService {


  private final TransplantRepository transplantRepository;

  public TransplantServiceImpl(TransplantRepository transplantRepository) {
    this.transplantRepository = transplantRepository;
  }

  @Override
  public List<Transplant> getAllTransplants() {
    return transplantRepository.findAll();
  }

  @Override
  public Transplant getTransplantById(Long id) throws NotFoundException {
    Optional<Transplant> transplant = transplantRepository.findById(id);
    return transplant.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public Transplant saveTransplant(Transplant transplant) {
    return transplantRepository.save(transplant);
  }

  @Override
  public Transplant updateTransplant(Long id, Transplant transplant) {
    Optional<Transplant> transplantUpdate = transplantRepository.findById(id);
    if (transplantUpdate != null) {
      transplant.setId(transplantUpdate.get().getId());
      transplantRepository.save(transplant);
      return transplant;
    }
    return null;
  }
}
