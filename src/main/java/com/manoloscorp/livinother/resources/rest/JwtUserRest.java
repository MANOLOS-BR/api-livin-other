package com.manoloscorp.livinother.resources.rest;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtUserRest implements Serializable {

  private static final long serialVersionUID = 3644604865327493930L;
  private String username;
  private String password;

}
