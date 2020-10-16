package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Donation;
import com.manoloscorp.livinother.entities.Organ;
import com.manoloscorp.livinother.entities.Transplant;
import com.manoloscorp.livinother.entities.UserType;
import com.manoloscorp.livinother.resources.payload.response.DashboardResponse;
import com.manoloscorp.livinother.services.DonationServiceImpl;
import com.manoloscorp.livinother.services.OrganServiceImpl;
import com.manoloscorp.livinother.services.TransplantServiceImpl;
import com.manoloscorp.livinother.services.UserServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_DASHBOARD, produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardResource {

    private final UserServiceImpl userService;
    private final TransplantServiceImpl transplantService;
    private final DonationServiceImpl donationService;
    private final OrganServiceImpl organService;

    public DashboardResource(UserServiceImpl userService, TransplantServiceImpl transplantService, DonationServiceImpl donationService, OrganServiceImpl organService) {
        this.userService = userService;
        this.transplantService = transplantService;
        this.donationService = donationService;
        this.organService = organService;
    }

    @GetMapping
    public ResponseEntity<?> getDashboard() {

        Long countReceptor = userService.countUserByUserType(UserType.RECEPTOR);
        Long countDoador = userService.countUserByUserType(UserType.DOADOR);

        List<Organ> organList = organService.getAllOrgans();
        List<Transplant> transplantList = transplantService.getAllTransplants();
        List<Donation> donationList = donationService.getAllDonations();

        DashboardResponse dashboardResponse = new DashboardResponse(countReceptor, countDoador, organList, transplantList, donationList);

        return new ResponseEntity<>(dashboardResponse, HttpStatus.OK);

    }

}
