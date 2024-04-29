package com.pms.audit.controller;

import com.pms.audit.model.dto.AuditDTO;
import com.pms.audit.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pms/audit")
@RequiredArgsConstructor
public class PmsAuditController {

    private final AuditService auditService;

    @GetMapping("/findAll")
    public ResponseEntity<Page<AuditDTO>> getAudits(@RequestParam(required = false) Integer pageNumber,
                                                    @RequestParam(required = false) Integer pageSize) {
        return ResponseEntity.ok(auditService.getAllAudits(pageNumber, pageSize));
    }
}
