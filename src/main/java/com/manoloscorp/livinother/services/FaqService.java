package com.manoloscorp.livinother.services;

import com.manoloscorp.livinother.entities.Faq;
import com.manoloscorp.livinother.shared.exceptions.NotFoundException;

import java.util.List;

public interface FaqService {

  List<Faq> getAllFaqs();

  Faq getFaqById(Long id) throws NotFoundException;

  Faq saveFaq(Faq faq);

  Faq updateFaq(Long id, Faq faq);

}
