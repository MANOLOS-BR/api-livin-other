package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Donation;
import com.manoloscorp.livinother.resources.exceptions.NotFoundException;

import java.util.List;

public interface DonationService {

  List<Donation> getAllDonations();

  Donation getDonationById(Long id) throws NotFoundException;

  Donation saveDonation(Donation donation);

  Donation updateDonation(Long id, Donation donation);

}
