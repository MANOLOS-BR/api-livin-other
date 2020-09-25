package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Transplant;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;

import java.util.List;

public interface TransplantService {

  List<Transplant> getAllTransplants();

  Transplant getTransplantById(Long id) throws NotFoundException;

  Transplant saveTransplant(Transplant transplant);

  Transplant updateTransplant(Long id, Transplant transplant);

}
