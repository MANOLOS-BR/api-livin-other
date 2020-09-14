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

  @ManyToOne(cascade = CascadeType.DETACH, fetch=FetchType.LAZY)
  @JoinColumn(name="FK_ID_USER")
  private User user;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DT_CREATION")
  private Date dateCreation = new Date();

}
