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
  @Column(nullable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "fk_id_user", nullable = false)
  private User user;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date dateCreation = new Date();

}
