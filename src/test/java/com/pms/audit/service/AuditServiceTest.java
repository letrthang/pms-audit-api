package com.pms.audit.service;

import com.pms.audit.model.dto.AuditDTO;
import com.pms.audit.model.entity.AuditEntity;
import com.pms.audit.repository.AuditRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuditServiceTest {

    @MockBean
    private AuditRepository auditRepository;

    private AuditService auditService;

    @BeforeEach
    void setUp() {
        auditService = new AuditService(auditRepository);
    }

    @Test
    void testFindAllAudits_WhenPageSizeNotGiven() {
        int defaultPageSize = 15;
        Mockito.when(auditRepository
                .findAll(Mockito.any(PageRequest.class)))
                        .thenReturn(new PageImpl<>(getAudits(defaultPageSize)));
        Page<AuditDTO> actualAudits = auditService.getAllAudits(1, null);

        assertThat(actualAudits).isNotEmpty();
        assertThat(actualAudits.getTotalElements()).isEqualTo(15);
    }

    @Test
    void testFindAllAudits_WhenPageNoNotGiven() {
        Mockito.when(auditRepository
                        .findAll(Mockito.any(PageRequest.class)))
                .thenReturn(new PageImpl<>(getAudits(12)));
        Page<AuditDTO> actualAudits = auditService.getAllAudits(null, 12);

        assertThat(actualAudits).isNotEmpty();
        assertThat(actualAudits.getTotalElements()).isEqualTo(12);
    }

    @Test
    void testFindAllAudits_WhenAllParamsProvided() {
        Mockito.when(auditRepository
                        .findAll(Mockito.any(PageRequest.class)))
                .thenReturn(new PageImpl<>(getAudits(12)));
        Page<AuditDTO> actualAudits = auditService.getAllAudits(2, 12);

        assertThat(actualAudits).isNotEmpty();
        assertThat(actualAudits.getTotalElements()).isEqualTo(12);
        assertThat(actualAudits.getSize()).isEqualTo(12);

    }

    private List<AuditEntity> getAudits(int pageSize) {
        List<AuditEntity> auditEntities = new ArrayList<>();

        for(int i=0;i < pageSize; i++) {
            auditEntities.add(AuditEntity.builder().id(BigInteger.valueOf(i+1)).build());
        }
        return auditEntities;
    }
}
