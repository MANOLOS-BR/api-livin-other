package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Ischemia;
import com.manoloscorp.livinother.repositories.IschemiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IschemiaServiceImpl implements IschemiaService {

  private IschemiaRepository ischemiaRepository;

  public IschemiaServiceImpl(IschemiaRepository ischemiaRepository) {
    this.ischemiaRepository = ischemiaRepository;
  }

  @Override
  public List<Ischemia> getAllIschemias() {
    return ischemiaRepository.findAll();
  }

  @Override
  public Ischemia saveIschemia(Ischemia ischemia) {
    return ischemiaRepository.save(ischemia);
  }

  @Override
  public Ischemia updateIschemia(Long id, Ischemia ischemia) {
    Optional<Ischemia> ischemiaOptional = ischemiaRepository.findById(id);
    if (ischemiaOptional != null) {
      ischemia.setId(ischemiaOptional.get().getId());
      ischemiaRepository.save(ischemia);
      return ischemia;
    }
    return null;
  }
}
