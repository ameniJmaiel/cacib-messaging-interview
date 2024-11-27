package com.cacib.interview.demo.service;

import com.cacib.interview.demo.entity.Partner;
import com.cacib.interview.demo.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;

    @Autowired
    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;

    }

    public List<Partner> getAllPartners() {
            return partnerRepository.findAll();
        }

    public Partner addPartner(Partner partner) {
        return partnerRepository.save(partner);
    }


    public void deletePartner(Long id) {
        if (!partnerRepository.existsById(id)) {
            throw new RuntimeException("Partner not found with id: " + id);}
        partnerRepository.deleteById(id);}
}
