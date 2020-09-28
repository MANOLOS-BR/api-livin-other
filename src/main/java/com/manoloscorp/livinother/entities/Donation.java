package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_DONATION")
@Data
public class Donation {
//  https://www.saude.gov.br/saude-de-a-z/doacao-de-orgaos/#estatisticas
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_DONATION", nullable = false)
  private Long id;

  @Column(name="YEAR", nullable = false)
  private Long year;

  @ManyToOne
  @JoinColumn(name = "FK_ID_STATE")
  private State state;

  @Column(name="POTENTIAL_DONOR", nullable = false)
  private Long potentialDonor;

  @Column(name="EFFECTIVE_DONOR", nullable = false)
  private Long effectiveDonor;

  @Column(name="EFFECTIVENESS_PERCENT", nullable = false)
  private Double effectivenessPercent;

  @Column(name="FAMILY_INTERVIEW", nullable = false)
  private Long familyInterview;

  @Column(name="FAMILY_NEGATIVE", nullable = false)
  private Long familyNegative;

  @Column(name="FAMILY_NEGATIVE_PERCENT", nullable = false)
  private Double familyNegativePercent;

}
