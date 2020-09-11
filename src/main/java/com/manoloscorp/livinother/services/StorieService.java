package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.entities.Storie;

import java.util.List;

public interface StorieService {

  List<Storie> getAllStories();

  Storie saveStorie(Storie storie);

}
