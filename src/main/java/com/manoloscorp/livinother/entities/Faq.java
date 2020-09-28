package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_FAQ")
@Data
public class Faq {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID_FAQ", nullable = false)
  private Long id;

  @Column(name = "QUESTION", nullable = false)
  private String question;

  @Column(name = "ANSWER", nullable = false)
  private String answer;
}
