package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_CITY")
@Data
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_CITY", nullable = false)
  private Long id;

//  @ManyToOne
//  @JoinColumn(name = "ID_STATE")
//  private State state;

  @Column(name = "NM_CITY")
  private String name;

}
