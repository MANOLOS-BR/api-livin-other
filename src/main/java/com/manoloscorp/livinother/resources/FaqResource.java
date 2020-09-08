package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.services.FaqServiceImpl;
import com.manoloscorp.livinother.shared.RestConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(RestConstants.APPLICATION_API + RestConstants.RESOURCE_FAQS)
public class FaqResource {

  private final FaqServiceImpl faqService;

  public FaqResource(FaqServiceImpl faqService) {
    this.faqService = faqService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> getFaqs() {
    List<Faq> faqList = faqService.getAllFaqs();
    return new ResponseEntity<List>(faqList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?>  getFaqById(@PathVariable Long id) {
    Faq faq = faqService.getFaqById(id);
    return ResponseEntity.ok().body(faq);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> createFaq(@RequestBody Faq faq){
    faqService.saveFaq(faq);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(faq.getId())
            .toUri();

    return ResponseEntity.created(uri).body(faq);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateFaq(@PathVariable Long id, @RequestBody Faq faq) {
    faq = faqService.updateFaq(id, faq);
    return ResponseEntity.ok().body(faq);
  }
}
