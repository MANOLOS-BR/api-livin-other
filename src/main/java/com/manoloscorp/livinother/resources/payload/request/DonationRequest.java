package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DonationRequest {

  @NotNull
  private Long year;

  @NotNull
  private Long state;

  @NotNull
  private Long potentialDonor;

  @NotNull
  private Long effectiveDonor;

  @NotNull
  private Double effectivenessPercent;

  @NotNull
  private Long familyInterview;

  @NotNull
  private Long familyNegative;

  @NotNull
  private Double familyNegativePercent;

}
