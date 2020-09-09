package com.manoloscorp.livinother.resources.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtTokenRest implements Serializable {

  private static final long serialVersionUID = -7244206013809971816L;
  private final String jwttoken;

}
