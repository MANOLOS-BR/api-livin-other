package com.manoloscorp.livinother.resources.payload.response;

import com.manoloscorp.livinother.entities.UserType;
import com.manoloscorp.livinother.resources.payload.request.MedicalHistoryRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class UserResponse implements Serializable {

  private String name;

  private String email;

  private LocalDate dataNascimento;

  private String genero;

  private UserType userType;

  private MedicalHistoryRequest medicalHistory;

}
