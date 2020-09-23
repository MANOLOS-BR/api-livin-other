package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Ischemia;
import com.manoloscorp.livinother.entities.State;
import com.manoloscorp.livinother.resources.payload.request.IschemiaRequest;
import com.manoloscorp.livinother.services.IschemiaServiceImpl;
import com.manoloscorp.livinother.services.StateServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.hibernate.stat.internal.StatisticsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_STATE, produces = MediaType.APPLICATION_JSON_VALUE)
public class StateResource {

  private final StateServiceImpl stateService;
  private final ModelMapper mapper;

  public StateResource(StateServiceImpl stateService, ModelMapper mapper) {
    this.stateService = stateService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getAllStates() {
    List<State> stateList = stateService.getAllStates();
    return new ResponseEntity<List>(stateList, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createState(@RequestBody State stateRequest){

    State state = mapper.map(stateRequest, State.class);

    stateService.saveState(state);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(state.getId())
            .toUri();

    return ResponseEntity.created(uri).body(stateRequest);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateState(@PathVariable Long id, @RequestBody State state) {
    state = stateService.updateState(id, state);
    return ResponseEntity.ok().body(state);
  }

}
