package com.manoloscorp.livinother.resources.payload.response;

import com.manoloscorp.livinother.entities.Donation;
import com.manoloscorp.livinother.entities.Organ;
import com.manoloscorp.livinother.entities.Transplant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private Long transplants;
    private Long donations;
    private List<Organ> organList;
    private List<Transplant> transplantList;
    private List<Donation> donationList;

}
