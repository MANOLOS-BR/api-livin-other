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
import java.util.List;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_LEADS, produces = MediaType.APPLICATION_JSON_VALUE)
public class LeadResource {

  /*
  * Implementar paginacao
  */

  private final UserServiceImpl userService;

  public LeadResource(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping
  public ResponseEntity<?> getLeads() {
    List<User> userList = userService.getAllUsers();
    return new ResponseEntity<List>(userList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?>  getLeadById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return ResponseEntity.ok().body(user);
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

  @PutMapping(value = "/{id}")
  public ResponseEntity<User> updateLead(@PathVariable Long id, @RequestBody User user) {
    user = userService.updateUser(id, user);
    return ResponseEntity.ok().body(user);
  }
}
