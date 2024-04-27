package com.pms.audit.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Entity
@Table(name = "instrument")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstrumentEntity {
    @Id
    private String  instrumentId;
    private BigDecimal instrumentValue;
    private String instrumentName;
    private String instrumentType;

}
