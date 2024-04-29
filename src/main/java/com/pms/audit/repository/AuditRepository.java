package com.pms.audit.repository;

import com.pms.audit.model.entity.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, BigInteger>, JpaSpecificationExecutor<AuditEntity> {
}
