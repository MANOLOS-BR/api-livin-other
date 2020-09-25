package com.manoloscorp.livinother.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = -1299061206641026380L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_USER", nullable = false)
  private Long id;

  @Column(name = "NM_USER", nullable = false, length = 100)
  private String name;

  @Column(name = "EMAIL", nullable = false, length = 100)
  private String email;

  @Column(name = "PASSWORD", nullable = false, length = 255)
  private String password;

  //  @Temporal(TemporalType.DATE)
  @Column(name = "DT_BIRTH")
  private LocalDate dataNascimento;

  @Column(name = "DS_GENRE", nullable = false, length = 100)
  private String genero;

  @Column(name = "TP_USER", nullable = false)
  private UserType userType;

  @MapsId
  @OneToOne(cascade = CascadeType.ALL)
  private MedicalHistory medicalHistory;

  @OneToMany(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY,
          mappedBy = "user")
  private List<Storie> stories = new ArrayList<>();

  public void setDataNascimento(String dataNascimento) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate localDate = LocalDate.parse(dataNascimento, formatter);
    this.dataNascimento = localDate;
  }
}
