package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.State;

import java.util.List;

public interface StateService {

  List<State> getAllStates();

  State saveState(State state);

  State updateState(Long id, State state);

}
