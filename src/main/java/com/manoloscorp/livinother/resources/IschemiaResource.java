package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Ischemia;
import com.manoloscorp.livinother.resources.payload.request.IschemiaRequest;
import com.manoloscorp.livinother.services.IschemiaServiceImpl;
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
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_ISCHEMIA, produces = MediaType.APPLICATION_JSON_VALUE)
public class IschemiaResource {

  private final IschemiaServiceImpl ischemiaService;
  private final ModelMapper mapper;

  public IschemiaResource(IschemiaServiceImpl ischemiaService, ModelMapper mapper) {
    this.ischemiaService = ischemiaService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getIschemias() {
    List<Ischemia> ischemiaList = ischemiaService.getAllIschemias();
    return new ResponseEntity<List>(ischemiaList, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createIschemia(@RequestBody IschemiaRequest ischemiaRequest){

    Ischemia ischemia = mapper.map(ischemiaRequest, Ischemia.class);

    ischemiaService.saveIschemia(ischemia);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(ischemia.getId())
            .toUri();

    return ResponseEntity.created(uri).body(ischemiaRequest);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateIschemia(@PathVariable Long id, @RequestBody Ischemia ischemia) {
    ischemia = ischemiaService.updateIschemia(id, ischemia);
    return ResponseEntity.ok().body(ischemia);
  }

}
