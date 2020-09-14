package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_STORIE")
@Data
public class Storie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_STORIE", nullable = false)
  private Long id;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DT_CREATION")
  private Date dateCreation = new Date();

  @ManyToOne
  @JoinColumn(name = "ID_USER")
  private User user;

}
