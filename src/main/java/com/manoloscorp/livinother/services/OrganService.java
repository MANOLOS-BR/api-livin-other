package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Organ;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;

import java.util.List;

public interface OrganService {

  List<Organ> getAllOrgans();

  Organ getOrganById(Long id) throws NotFoundException;

  Organ saveOrgan(Organ organ);

  Organ updateOrgan(Long id, Organ organ);

}
