package com.manoloscorp.livinother.resources.payload.request;

import com.manoloscorp.livinother.entities.User;
import com.manoloscorp.livinother.resources.payload.response.UserResponse;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class StorieRequest {

  private Long idUser;

  @NotNull
  private Date dateCreation = new Date();

}
