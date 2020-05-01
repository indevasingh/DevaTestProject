package com.deva.testproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deva.testproject.model.Audit;

public interface AuditRepository extends JpaRepository<Audit, Integer> {

}
