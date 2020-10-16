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
  @JoinColumn(name = "fk_id_organ")
  private Organ organ;

  @Column(nullable = false)
  private Long queueAmount;

  @Column(nullable = false)
  private Long numberTransplants;

}
