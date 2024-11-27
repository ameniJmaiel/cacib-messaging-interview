package com.cacib.interview.demo.repository;

import com.cacib.interview.demo.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, Long> {
}
