package com.manoloscorp.livinother.resources.payload.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StorieResponse implements Serializable {

  private Long user;
  private Date dateCreation;

}
