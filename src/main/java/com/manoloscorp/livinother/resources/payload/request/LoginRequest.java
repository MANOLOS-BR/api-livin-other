package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginRequest implements Serializable {

  private static final long serialVersionUID = 3644604865327493930L;

  @NotNull
  @NotEmpty
  private String username;

  @NotNull
  @NotEmpty
  private String password;

}
