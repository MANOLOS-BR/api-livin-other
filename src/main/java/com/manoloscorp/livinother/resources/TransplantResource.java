package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Organ;
import com.manoloscorp.livinother.entities.State;
import com.manoloscorp.livinother.entities.Transplant;
import com.manoloscorp.livinother.resources.payload.request.TransplantRequest;
import com.manoloscorp.livinother.services.OrganServiceImpl;
import com.manoloscorp.livinother.services.StateServiceImpl;
import com.manoloscorp.livinother.services.TransplantServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_TRANSPLANT, produces = MediaType.APPLICATION_JSON_VALUE)
public class TransplantResource {

  private final TransplantServiceImpl transplantService;
  private final StateServiceImpl stateService;
  private final OrganServiceImpl organService;

  private final ModelMapper mapper;

  public TransplantResource(TransplantServiceImpl transplantService, StateServiceImpl stateService, OrganServiceImpl organService, ModelMapper mapper) {
    this.transplantService = transplantService;
    this.stateService = stateService;
    this.organService = organService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getTransplants() {
    List<Transplant> transplantList = transplantService.getAllTransplants();
    return new ResponseEntity<List>(transplantList, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createTransplant(@RequestBody TransplantRequest transplantRequest){

    State state = stateService.getStateById(transplantRequest.getState());
    Organ organ = organService.getOrganById(transplantRequest.getOrgan());

    Transplant transplant = mapper.map(transplantRequest, Transplant.class);

    transplant.setState(state);
    transplant.setOrgan(organ);

    transplantService.saveTransplant(transplant);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(transplant.getId())
            .toUri();

    return ResponseEntity.created(uri).body(transplantRequest);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateTransplant(@PathVariable Long id, @RequestBody Transplant transplant) {
    transplant = transplantService.updateTransplant(id, transplant);
    return ResponseEntity.ok().body(transplant);
  }

}
