package com.manoloscorp.livinother.resources.payload.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

  private static final long serialVersionUID = 2843705543933953778L;

  public NotFoundException(Object object) {
    super("Resource not found. Id " + object);
  }

}
