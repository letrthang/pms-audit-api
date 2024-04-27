package com.pms.audit.service;


import com.pms.audit.model.dto.AuditDTO;
import com.pms.audit.model.entity.AuditEntity;
import com.pms.audit.repository.AuditRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import static com.pms.audit.mapper.CustomSingletonMapper.getInstance;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;

    private static final Integer DEFAULT_PAGE_SIZE = 15;

    private static final Integer DEFAULT_PAGE_NO = 1;

    public Page<AuditDTO> getAllAudits(Integer pageNo, Integer pageSize) {

        if(ObjectUtils.isEmpty(pageNo)){
            pageNo = DEFAULT_PAGE_NO;
        }
        if(ObjectUtils.isEmpty(pageSize)) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize);
        Page<AuditEntity> allAudits = auditRepository.findAll(pageRequest);
        return allAudits.map(entity ->
                getInstance().toDto(AuditDTO.class, entity));
    }

    public void saveAudit(AuditDTO auditDTO) {
        auditRepository.save(getInstance().toEntity(AuditEntity.class, auditDTO));
    }

}
