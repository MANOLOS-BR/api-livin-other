package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Storie;
import com.manoloscorp.livinother.entities.User;

import java.util.List;

public interface StorieService {

  List<Storie> getAllStories();

  User saveStorie(User user);

}
