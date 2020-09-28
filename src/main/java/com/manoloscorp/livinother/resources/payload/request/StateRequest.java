package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StateRequest {

  @NotNull
  private String region;

  @NotNull
  private String name;

  @NotNull
  private String stateAcronym;

}
