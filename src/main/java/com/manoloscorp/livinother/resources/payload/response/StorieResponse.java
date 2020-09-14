package com.manoloscorp.livinother.resources.payload.response;

import com.manoloscorp.livinother.entities.User;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class StorieResponse implements Serializable {

  private String user;
  private Date dateCreation = new Date();

}
