package com.cacib.interview.demo.controller;

import com.cacib.interview.demo.entity.Partner;
import com.cacib.interview.demo.repository.PartnerRepository;
import com.cacib.interview.demo.service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/partners")
/*@CrossOrigin(
        origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)*/
public class PartnerController {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private PartnerService partnerService;

    @GetMapping("/all")
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }

    @PostMapping("/create")
    public Partner createPartner(@RequestBody Partner partner) {
        return partnerService.addPartner(partner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePartner(@PathVariable Long id) {
        if (partnerRepository.existsById(id)) {
            partnerService.deletePartner(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Partner with ID " + id + " deleted successfully.");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
