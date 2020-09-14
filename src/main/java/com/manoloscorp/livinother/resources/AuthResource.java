package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.configuration.security.jwt.JwtTokenUtil;
import com.manoloscorp.livinother.configuration.security.services.UserDetailsServiceImpl;
import com.manoloscorp.livinother.resources.payload.request.LoginRequest;
import com.manoloscorp.livinother.resources.payload.response.JwtResponse;
import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_AUTH, produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthResource {

  private AuthenticationManager authenticationManager;
  private JwtTokenUtil jwtTokenUtil;
  private UserDetailsServiceImpl userDetailsServiceImpl;

  public AuthResource(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsServiceImpl) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsServiceImpl = userDetailsServiceImpl;
  }

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest authenticationRequest) throws Exception {

    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtResponse("Bearer", token));
  }

  @DeleteMapping("/logout")
  public ResponseEntity<?> logoutUser(){
    return ResponseEntity.ok("");
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED - ", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS - ", e);
    }
  }
}
