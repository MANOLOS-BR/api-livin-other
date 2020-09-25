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

  @MapsId
  @OneToOne
  private Organ organ;

  @Column(nullable = false)
  private String timeIschemia;

  @Column(name="SLG_UNIT", nullable = false)
  private String unit;

}
