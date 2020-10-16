package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Donation;
import com.manoloscorp.livinother.services.DonationServiceImpl;
import com.manoloscorp.livinother.services.StateServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_DONATION, produces = MediaType.APPLICATION_JSON_VALUE)
public class DonationResource {

  private final DonationServiceImpl donationService;
  private final StateServiceImpl stateService;
  private final ModelMapper mapper;

  public DonationResource(DonationServiceImpl donationService, StateServiceImpl stateService, ModelMapper mapper) {
    this.donationService = donationService;
    this.stateService = stateService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getDonations() {
    List<Donation> donationList = donationService.getAllDonations();
    return new ResponseEntity<List>(donationList, HttpStatus.OK);
  }

}
