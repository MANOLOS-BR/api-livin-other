package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FaqRequest {

  @NotNull
  private String question;

  @NotNull
  private String answer;

}
