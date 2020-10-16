package com.manoloscorp.livinother.resources.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

  private Long user;

  private String token;

}
