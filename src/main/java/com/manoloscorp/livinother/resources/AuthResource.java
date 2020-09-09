package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.configuration.security.jwt.JwtTokenUtil;
import com.manoloscorp.livinother.configuration.security.jwt.JwtUserDetailsService;
import com.manoloscorp.livinother.resources.rest.JwtTokenRest;
import com.manoloscorp.livinother.resources.rest.JwtUserRest;
import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(RestConstants.APPLICATION_API + RestConstants.RESOURCE_AUTH)
public class AuthResource {

  private AuthenticationManager authenticationManager;
  private JwtTokenUtil jwtTokenUtil;
  private JwtUserDetailsService userDetailsService;

  public AuthResource(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsService userDetailsService) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenUtil = jwtTokenUtil;
    this.userDetailsService = userDetailsService;
  }

  @PostMapping("/login")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtUserRest authenticationRequest) throws Exception {

    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
    final String token = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new JwtTokenRest(token));
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
