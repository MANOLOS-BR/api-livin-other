package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_USER")
@Data
public class User implements Serializable {

  private static final long serialVersionUID = -1299061206641026380L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_USER", nullable = false)
  private Long id;

  @Column(name = "NM_USER", nullable = false, length = 100)
  private String name;

  @Column(name = "EMAIL", nullable = false, length = 100)
  private String email;

  @Column(name = "PASSWORD", nullable = false, length = 255)
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "DT_BIRTH")
  private Date dataNascimento = new Date();

  @Column(name = "DS_GENRE", nullable = false, length = 100)
  private String genero;

  @Column(name = "TP_USER", nullable = false)
  private UserType userType;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @MapsId
  private MedicalHistory medicalHistory;

//  @OneToMany(mappedBy = "user")
//  private List<Storie> orders = new ArrayList<>();

}
