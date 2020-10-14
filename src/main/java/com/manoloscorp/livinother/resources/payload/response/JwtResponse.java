package com.manoloscorp.livinother.resources.payload.response;

import com.manoloscorp.livinother.entities.Faq;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

  private Long user;

  private String token;

}
