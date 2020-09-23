package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class IschemiaRequest {

  @NotNull
  private String organ;

  @NotNull
  private String timeIschemia;

  @NotNull
  private String unit;

}
