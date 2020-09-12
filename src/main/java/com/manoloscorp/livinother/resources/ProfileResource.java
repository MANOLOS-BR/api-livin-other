package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.PROFILE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfileResource {

  @GetMapping("/{id}")
  public ResponseEntity<?> getProfileById(@PathVariable Long id) {
//    User user = userService.getUserById(id);
//    return ResponseEntity.ok().body(user);
    return null;
  }


  @PutMapping(value = "/{id}")
  public ResponseEntity<User> updateProfile(@PathVariable Long id, @RequestBody User user) {
//    user = userService.updateUser(id, user);
//    return ResponseEntity.ok().body(user);
    return null;
  }

}
