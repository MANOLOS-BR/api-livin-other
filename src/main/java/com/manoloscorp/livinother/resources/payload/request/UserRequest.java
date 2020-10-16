package com.manoloscorp.livinother.resources.payload.request;

import com.manoloscorp.livinother.entities.UserType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class UserRequest implements Serializable {

  @NotNull
  private String name;

  @NotNull
  private String email;

  @NotNull
  private String password;

  @NotNull
  private LocalDate birthDate;

  @NotNull
  private String genre;

  @NotNull
  private UserType userType;

  @NotNull
  private MedicalHistoryRequest medicalHistory;

}
