package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Ischemia;

import java.util.List;

public interface IschemiaService {

  List<Ischemia> getAllIschemias();
  Ischemia saveIschemia(Ischemia Ischemia);
  Ischemia updateIschemia(Long id, Ischemia ischemia);

}
