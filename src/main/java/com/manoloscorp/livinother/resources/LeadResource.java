package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.AppUser;
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
    List<AppUser> appUserList = userService.getAllUsers();
    return new ResponseEntity<List>(appUserList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?>  getLeadById(@PathVariable Long id) {
    AppUser appUser = userService.getUserById(id);
    return ResponseEntity.ok().body(appUser);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<AppUser> createLead(@RequestBody AppUser appUser){
    userService.saveUser(appUser);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(appUser.getId())
            .toUri();
    return ResponseEntity.created(uri).body(appUser);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<AppUser> updateLead(@PathVariable Long id, @RequestBody AppUser appUser) {
    appUser = userService.updateUser(id, appUser);
    return ResponseEntity.ok().body(appUser);
  }
}
