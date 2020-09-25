package com.manoloscorp.livinother.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_TRANSPLANT")
@Data
public class Transplant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "FK_ID_STATE")
  private State state;

  @MapsId
  @OneToOne
  private Organ organ;

  @Column(nullable = false)
  private Long year;

  @Column(nullable = false)
  private Long qtdTransplant;

}
