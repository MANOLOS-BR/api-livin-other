package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.repositories.FaqRepository;
import com.manoloscorp.livinother.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaqServiceImpl implements FaqService{

  private final FaqRepository faqRepository;

  public FaqServiceImpl(FaqRepository faqRepository) {
    this.faqRepository = faqRepository;
  }

  @Override
  public List<Faq> getAllFaqs() {
    return faqRepository.findAll();
  }

  @Override
  public Faq getFaqById(Long id) throws NotFoundException {
    Optional<Faq> faq = faqRepository.findById(id);
    return faq.orElseThrow(() -> new NotFoundException(id));
  }

  @Override
  public Faq saveFaq(Faq faq) {
    return faqRepository.save(faq);
  }

  @Override
  public Faq updateFaq(Long id, Faq faq) {
    Optional<Faq> faqUpdate = faqRepository.findById(id);
    if (faqUpdate != null) {
      faq.setId(faqUpdate.get().getId());
      faqRepository.save(faq);
      return faq;
    }
    return null;
  }
}

