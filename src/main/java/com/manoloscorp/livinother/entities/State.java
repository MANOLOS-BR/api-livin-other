package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_STATE")
@Data
public class State {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String region;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String stateAcronym;

}
