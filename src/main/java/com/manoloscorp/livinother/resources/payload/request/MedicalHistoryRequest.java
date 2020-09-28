package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MedicalHistoryRequest {

  @NotNull
  private Double weight;

  @NotNull
  private Double height;

  @NotNull
  private Boolean drugAddict;

  @NotNull
  private Boolean alcoholConsumption;

  @NotNull
  private Boolean communicableDisease;

  @NotNull
  private Boolean degenerativeDisease;

  @NotNull
  private Boolean practicePhysicalActivity;

}
