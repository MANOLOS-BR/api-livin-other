package com.manoloscorp.livinother.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_ORGAN")
@Data
public class Organ {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String timeIschemia;

  @Column(nullable = false)
  private String unit;

}
