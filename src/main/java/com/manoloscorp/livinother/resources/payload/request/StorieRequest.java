package com.manoloscorp.livinother.resources.payload.request;

import com.manoloscorp.livinother.entities.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class StorieRequest {

  @NotNull
  private User user;

  @NotNull
  private Date dateCreation = new Date();

}
