package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Donation;
import com.manoloscorp.livinother.entities.Ischemia;
import com.manoloscorp.livinother.resources.payload.request.DonationRequest;
import com.manoloscorp.livinother.resources.payload.request.IschemiaRequest;
import com.manoloscorp.livinother.services.DonationServiceImpl;
import com.manoloscorp.livinother.services.StateServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_DONATION, produces = MediaType.APPLICATION_JSON_VALUE)
public class DonationResource {

  private final DonationServiceImpl donationService;
  private final ModelMapper mapper;

  public DonationResource(DonationServiceImpl donationService, ModelMapper mapper) {
    this.donationService = donationService;
    this.mapper = mapper;
  }

  @GetMapping
  public ResponseEntity<?> getDonations() {
    List<Donation> donationList = donationService.getAllDonations();
    return new ResponseEntity<List>(donationList, HttpStatus.OK);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createIschemia(@RequestBody DonationRequest donationRequest){

    Donation donation = mapper.map(donationRequest, Donation.class);

    donationService.saveDonation(donation);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(donation.getId())
            .toUri();

    return ResponseEntity.created(uri).body(donationRequest);
  }

}
