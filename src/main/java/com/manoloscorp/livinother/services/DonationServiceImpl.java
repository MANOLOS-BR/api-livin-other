package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Donation;
import com.manoloscorp.livinother.repositories.DonationRepository;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService {

  private final DonationRepository donationRepository;

  public DonationServiceImpl(DonationRepository donationRepository) {
    this.donationRepository = donationRepository;
  }

  @Override
  public List<Donation> getAllDonations() {
    return donationRepository.findAll();
  }

  @Override
  public Donation getDonationById(Long id) throws NotFoundException {
    Optional<Donation> donation = donationRepository.findById(id);
    return donation.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public Donation saveDonation(Donation donation) {
    return donationRepository.save(donation);
  }

  @Override
  public Donation updateDonation(Long id, Donation donation) {
    Optional<Donation> donationUpdate = donationRepository.findById(id);
    if (donationUpdate != null) {
      donation.setId(donationUpdate.get().getId());
      donationRepository.save(donation);
      return donation;
    }
    return null;
  }
}
