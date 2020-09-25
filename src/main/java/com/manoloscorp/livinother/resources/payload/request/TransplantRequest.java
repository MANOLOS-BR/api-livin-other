package com.manoloscorp.livinother.resources.payload.request;

import com.manoloscorp.livinother.entities.Organ;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class TransplantRequest {

  @NotNull
  private Long state;

  @NotNull
  private Long organ;

  @NotNull
  private Long year;

  @NotNull
  private Long qtdTransplant;


}
