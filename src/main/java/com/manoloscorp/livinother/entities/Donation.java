package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_DONATION")
@Data
public class Donation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_DONATION", nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "FK_ID_STATE")
  private State state;

  @Column(name="POTENTIAL_DONOR", nullable = false)
  private Long potentialDonor;

  @Column(name="EFFECTIVE_DONOR", nullable = false)
  private Long effectiveDonor;

  @Column(name="FAMILY_INTERVIEW", nullable = false)
  private Long familyInterview;

  @Column(name="FAMILY_NEGATIVE", nullable = false)
  private Long familyNegative;


}
