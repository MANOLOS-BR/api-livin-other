package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.resources.payload.response.MessageResponse;
import com.manoloscorp.livinother.services.UserServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_LEADS, produces = MediaType.APPLICATION_JSON_VALUE)
public class LeadResource {


  private final UserServiceImpl userService;

  public LeadResource(UserServiceImpl userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createLead(@RequestBody User user){

    if (userService.existsUserByEmail(user.getEmail())){
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }

    userService.saveUser(user);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();

    return ResponseEntity.created(uri).body(new MessageResponse("User registered successfully!"));
  }

}
