package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_DASHBOARD, produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardResource {

  @GetMapping
  public ResponseEntity<?> getDashboard() {
    return null;
  }

}
