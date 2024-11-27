package com.cacib.interview.demo.service;

import com.cacib.interview.demo.entity.Partner;
import com.cacib.interview.demo.entity.enums.Direction;
import com.cacib.interview.demo.entity.enums.ProceedFlowType;
import com.cacib.interview.demo.repository.PartnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PartnerServiceTest {

    @InjectMocks
    private PartnerService partnerService;

    @Mock
    private PartnerRepository partnerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    void testAddPartner() {
        Partner partner = new Partner("alias1", "INBOUND", "App1", "MESSAGE",Direction.valueOf("INBOUND"), ProceedFlowType.valueOf("MESSAGE"));

        when(partnerRepository.save(partner)).thenReturn(partner);

        Partner savedPartner = partnerService.addPartner(partner);

        assertNotNull(savedPartner);
        assertEquals("alias1", savedPartner.getAlias());
        verify(partnerRepository, times(1)).save(partner);
    }

    @Test
    void testGetAllPartners() {
        Partner partner1 = new Partner("alias1", "INBOUND", "App1", "MESSAGE",Direction.valueOf("INBOUND"), ProceedFlowType.valueOf("MESSAGE"));
        Partner partner2 = new Partner("alias2", "OUTBOUND", "App2", "ALERTING",Direction.valueOf("OUTBOUND"), ProceedFlowType.valueOf("ALERTING"));

        when(partnerRepository.findAll()).thenReturn(Arrays.asList(partner1, partner2));

        var partners = partnerService.getAllPartners();

        assertEquals(2, partners.size());
        assertEquals("alias1", partners.get(0).getAlias());
        verify(partnerRepository, times(1)).findAll();
    }



    @Test
    public void testDeletePartner() {
        Long partnerId = 1L;
        when(partnerRepository.existsById(partnerId)).thenReturn(true);

        partnerService.deletePartner(partnerId);

        verify(partnerRepository, times(1)).deleteById(partnerId);
    }

}
