package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.entities.Storie;
import com.manoloscorp.livinother.resources.payload.response.MessageResponse;
import com.manoloscorp.livinother.services.StorieServiceImpl;
import com.manoloscorp.livinother.services.UserServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
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

  public StorieResource(StorieServiceImpl storiesService, UserServiceImpl userService) {
    this.storiesService = storiesService;
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<?> getStories() {
    List<Storie> storieList = storiesService.getAllStories();
    return new ResponseEntity<List>(storieList, HttpStatus.OK);
  }

  @PostMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createStories(@PathVariable Long id, @RequestBody Storie storie) {

    if (!userService.existsUserById(id)){
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: User is not found!"));
    }

    User user = userService.getUserById(id);
    storie.setUser(user);

    storiesService.saveStorie(storie);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(storie.getId())
            .toUri();

    return ResponseEntity.created(uri).body(new MessageResponse("Stories registered successfully!"));
  }

}
