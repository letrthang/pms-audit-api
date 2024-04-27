package com.pms.audit.model.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Setter
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@MappedSuperclass
@Data
@Generated
public class AuditDTO {
    private BigInteger id;

    private String transactionRef;

    private String instrumentId;

    private String tradeType;

    private String instrumentName;
    private String createdBy;

    private LocalDateTime auditDate;
}
