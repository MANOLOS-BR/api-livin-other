package com.manoloscorp.livinother.repositories;

import com.manoloscorp.livinother.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

}
