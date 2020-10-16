package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Storie;
import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.resources.payload.request.StorieRequest;
import com.manoloscorp.livinother.resources.payload.response.StorieResponse;
import com.manoloscorp.livinother.services.StorieServiceImpl;
import com.manoloscorp.livinother.services.UserServiceImpl;
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
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_HISTORIES, produces = MediaType.APPLICATION_JSON_VALUE)
public class StorieResource {

  private final StorieServiceImpl storiesService;
  private final UserServiceImpl userService;
  private final ModelMapper mapper;

  public StorieResource(StorieServiceImpl storiesService, UserServiceImpl userService, ModelMapper mapper) {
    this.storiesService = storiesService;
    this.userService = userService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getStories() {
    List<Storie> storieList = storiesService.getAllStories();

    return new ResponseEntity<List>(storieList, HttpStatus.OK);

  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createStories(@RequestBody StorieRequest storieRequest) {

    User user = userService.getUserById(storieRequest.getIdUser());

    Storie storie = new Storie();

    storie.setDateCreation(storieRequest.getDateCreation());
    storie.setUser(user);

    user.getStories().add(storie);

    storiesService.saveStorie(user);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(storie.getId())
            .toUri();

    return ResponseEntity.created(uri).body(storieRequest);
  }

  private StorieResponse getStorieResponse(Storie storie) {
    StorieResponse storieResponse = new StorieResponse();
    storieResponse.setUser(storie.getUser().getId());
    storieResponse.setDateCreation(storie.getDateCreation());
    return storieResponse;
  }

}
