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

  @Column(name="WEIGHT", nullable = false)
  private Double weight;

  @Column(name="HEIGHT", nullable = false)
  private Double height;

  @Column(name="DRUG ADDICT", nullable = false)
  private Boolean drugAddict;

  @Column(name="ALCOHOL_CONSUMPTION", nullable = false)
  private Boolean alcoholConsumption;

  @Column(name="COMMUNICABLE DISEASE", nullable = false)
  private Boolean communicableDisease;

  @Column(name="DEGENERATIVE_DISEASE", nullable = false)
  private Boolean degenerativeDisease;

  @Column(name="PRACTICE_PHYSICAL_ACTIVITY", nullable = false)
  private Boolean practicePhysicalActivity;

  @JsonIgnore
  @OneToOne(mappedBy = "medicalHistory", cascade = CascadeType.ALL)
  private AppUser appUser;

}
