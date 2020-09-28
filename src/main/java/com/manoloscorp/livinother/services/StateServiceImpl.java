package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.State;
import com.manoloscorp.livinother.repositories.StateRepository;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateServiceImpl implements StateService{

  private final StateRepository stateRepository;

  public StateServiceImpl(StateRepository stateRepository) {
    this.stateRepository = stateRepository;
  }

  @Override
  public List<State> getAllStates() {
    return stateRepository.findAll();
  }

  @Override
  public State getStateById(Long id) throws NotFoundException {
    Optional<State> state = stateRepository.findById(id);
    return state.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public State saveState(State state) {
    return stateRepository.save(state);
  }

  @Override
  public State updateState(Long id, State state) {
    Optional<State> stateUpdate = stateRepository.findById(id);
    if (stateUpdate != null) {
      state.setId(stateUpdate.get().getId());
      stateRepository.save(state);
      return state;
    }
    return null;
  }
}

