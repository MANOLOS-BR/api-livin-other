package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.entities.Organ;
import com.manoloscorp.livinother.resources.payload.request.FaqRequest;
import com.manoloscorp.livinother.resources.payload.request.OrganRequest;
import com.manoloscorp.livinother.services.FaqServiceImpl;
import com.manoloscorp.livinother.services.OrganServiceImpl;
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
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_ORGAN, produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganResource {

  private final OrganServiceImpl organService;
  private final ModelMapper mapper;

  public OrganResource(OrganServiceImpl organService, ModelMapper mapper) {
    this.organService = organService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getOrgans() {
    List<Organ> organList = organService.getAllOrgans();
    return new ResponseEntity<List>(organList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?>  getOrganById(@PathVariable Long id) {
    Organ organ = organService.getOrganById(id);
    return ResponseEntity.ok().body(organ);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createOrgan(@RequestBody OrganRequest organRequest){

    Organ organ = mapper.map(organRequest, Organ.class);

    organService.saveOrgan(organ);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(organ.getId())
            .toUri();

    return ResponseEntity.created(uri).body(organRequest);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateOrgan(@PathVariable Long id, @RequestBody Organ organ) {
    organ = organService.updateOrgan(id, organ);
    return ResponseEntity.ok().body(organ);
  }
}
