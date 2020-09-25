package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrganRequest {

  @NotNull
  private String name;

}
