package com.manoloscorp.livinother.resources;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.resources.payload.request.FaqRequest;
import com.manoloscorp.livinother.services.FaqServiceImpl;
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
@RequestMapping(value = RestConstants.APPLICATION_API + RestConstants.RESOURCE_FAQS, produces = MediaType.APPLICATION_JSON_VALUE)
public class FaqResource {

  private final FaqServiceImpl faqService;
  private final ModelMapper mapper;

  public FaqResource(FaqServiceImpl faqService, ModelMapper mapper) {
    this.faqService = faqService;
    this.mapper = mapper;
  }

  @GetMapping
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
  public ResponseEntity<?> createFaq(@RequestBody FaqRequest faqRequest){

    Faq faq = mapper.map(faqRequest, Faq.class);

    faqService.saveFaq(faq);

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(faq.getId())
            .toUri();

    return ResponseEntity.created(uri).body(faqRequest);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<?> updateFaq(@PathVariable Long id, @RequestBody Faq faq) {
    faq = faqService.updateFaq(id, faq);
    return ResponseEntity.ok().body(faq);
  }
}
