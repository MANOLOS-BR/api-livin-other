package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.shared.exceptions.NotFoundException;

import java.util.List;

public interface UserService {

  List<User> getAllUsers();

  User getUserById(Long id) throws NotFoundException;

  User saveUser(User user);

  User updateUser(Long id, User user);

}
