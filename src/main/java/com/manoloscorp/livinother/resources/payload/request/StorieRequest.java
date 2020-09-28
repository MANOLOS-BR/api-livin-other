package com.manoloscorp.livinother.resources.payload.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StorieRequest {

  @NotNull
  private Long idUser;

  @NotNull
  private Date dateCreation = new Date();


}
