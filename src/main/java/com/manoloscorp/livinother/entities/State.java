package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_STATE")
@Data
public class State {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_STATE", nullable = false)
  private Long id;

  @Column(name = "NM_STATE")
  private String name;

  @Column(name = "SLG_STATE")
  private String stateAcronym;

}
