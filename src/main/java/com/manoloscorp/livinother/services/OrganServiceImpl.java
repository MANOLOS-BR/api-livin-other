package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Organ;
import com.manoloscorp.livinother.repositories.OrganRepository;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganServiceImpl implements OrganService{

  private OrganRepository organRepository;

  public OrganServiceImpl(OrganRepository organRepository) {
    this.organRepository = organRepository;
  }

  @Override
  public List<Organ> getAllOrgans() {
    return organRepository.findAll();
  }

  @Override
  public Organ getOrganById(Long id) throws NotFoundException {
    Optional<Organ> organ = organRepository.findById(id);
    return organ.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public Organ saveOrgan(Organ organ) {
    return organRepository.save(organ);
  }

  @Override
  public Organ updateOrgan(Long id, Organ organ) {
    Optional<Organ> organOptional = organRepository.findById(id);
    if (organOptional != null) {
      organ.setId(organOptional.get().getId());
      organRepository.save(organ);
      return organ;
    }
    return null;
  }
}

