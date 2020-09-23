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

  private Long qtdTransplant;

//  private State state;


}
