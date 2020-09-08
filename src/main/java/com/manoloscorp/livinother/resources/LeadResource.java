package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.User;
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
@RequestMapping(RestConstants.APPLICATION_API + RestConstants.RESOURCE_LEADS)
public class LeadResource {

  /*
  * Implementar paginacao
  */

  private final UserServiceImpl userService;

  public LeadResource(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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
  public ResponseEntity<User> createLead(@RequestBody User user){
    userService.saveUser(user);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
    return ResponseEntity.created(uri).body(user);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<User> updateLead(@PathVariable Long id, @RequestBody User user) {
    user = userService.updateUser(id, user);
    return ResponseEntity.ok().body(user);
  }
}
