package com.pms.audit.listner;

import com.pms.audit.model.dto.AuditDTO;
import com.pms.audit.service.AuditService;
import com.pms.audit.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuditListener {

    private final AuditService auditService;

    /**
     *
     * @param message is a json message
     */
    @KafkaListener(topics = "${app.hackathon.audit-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        log.info("Received message: {}", message);
        AuditDTO auditDTO = JsonUtils.fromJson(message, AuditDTO.class);
        auditService.saveAudit(auditDTO);
        log.info("Audit saved.");
    }
}
