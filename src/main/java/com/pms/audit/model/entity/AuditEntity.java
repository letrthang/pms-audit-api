package com.pms.audit.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;


@Builder(toBuilder = true)
@Generated
@Entity
@Table(name = "audit")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name ="transaction_ref")
    private String transactionRef;
    @Column(name ="instrument_id")
    private String instrumentId;

    @Column(name = "trade_type")
    private String tradeType;

    @Column(name = "instrument_name")
    private String instrumentName;
    @Column(name ="created_by", updatable = false, nullable = false)
    private String createdBy;

    @Column(name = "audit_date", updatable = false, nullable = false)
    private LocalDateTime auditDate;

}
