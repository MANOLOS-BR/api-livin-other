package com.manoloscorp.livinother.resources.payload.response;

import com.manoloscorp.livinother.entities.UserType;
import com.manoloscorp.livinother.resources.payload.request.MedicalHistoryRequest;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserResponse implements Serializable {

  private String name;

  private String email;

  private LocalDate birthDate;

  private String genre;

  private UserType userType;

  private MedicalHistoryRequest medicalHistory;

}
