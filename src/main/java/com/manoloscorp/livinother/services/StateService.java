package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.entities.State;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;

import java.util.List;

public interface StateService {

  List<State> getAllStates();

  State getStateById(Long id) throws NotFoundException;

  State saveState(State state);

  State updateState(Long id, State state);

}
