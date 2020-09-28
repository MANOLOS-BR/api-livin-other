package com.manoloscorp.livinother.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORGAN")
@Data
public class Organ {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_ORGAN", nullable = false)
  private Long id;

  @Column(name="NM_ORGAN", nullable = false)
  private String name;

  @Column(nullable = false)
  private String timeIschemia;

  @Column(name="SLG_UNIT", nullable = false)
  private String unit;

}
