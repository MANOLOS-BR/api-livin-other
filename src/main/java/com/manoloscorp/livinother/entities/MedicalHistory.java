package com.manoloscorp.livinother.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_MEDICAL_HISTORY")
@Data
public class MedicalHistory implements Serializable {

  private static final long serialVersionUID = 3648564276027105819L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Double weight;

  @Column(nullable = false)
  private Double height;

  @Column(nullable = false)
  private Boolean drugAddict;

  @Column(nullable = false)
  private Boolean alcoholConsumption;

  @Column(nullable = false)
  private Boolean communicableDisease;

  @Column(nullable = false)
  private Boolean degenerativeDisease;

  @Column(nullable = false)
  private Boolean practicePhysicalActivity;

}
