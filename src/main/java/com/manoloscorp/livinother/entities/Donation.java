package com.manoloscorp.livinother.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_DONATION")
@Data
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DONATION", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "FK_ID_STATE")
    private State state;

    @Column(nullable = false)
    private Long potentialDonor;

    @Column(nullable = false)
    private Long effectiveDonor;

    @Column(nullable = false)
    private Long familyInterview;

    @Column(nullable = false)
    private Long familyNegative;


}
