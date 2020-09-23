package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_ISCHEMIA")
@Data
public class Ischemia {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String organ;

  private String timeIschemia;

  private String unit;

}
