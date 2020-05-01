package com.deva.testproject.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deva.testproject.model.Audit;
import com.deva.testproject.model.AuditResult;
import com.deva.testproject.model.CalcOpDto;
import com.deva.testproject.repository.AuditRepository;

@Service
public class AuditService {
	
	@Autowired
	private AuditRepository auditRepository;

	/**
     * To create Audit
     * @param calcOpDto	
     * @param operation, for which operation audit has to be done
     * @param result, result of the operation
     */
	public void createAuditRecord(CalcOpDto calcOpDto, String operation, Integer result) {
		Audit audit = createAuditData(calcOpDto, operation, result);
		auditRepository.save(audit);
	}
	
	/**
     * To get the audits records
     * @return AuditResult
     */
	public AuditResult getAuditResult() {
		List<Audit> audits = auditRepository.findAll();
		return new AuditResult(audits);
	}
	
	/**
     * Utility method: To create Audit object
     * @param calcOpDto	
     * @param operation, for which operation audit has to be done
     * @param result, result of the operation
     * @return Audit
     */
	private Audit createAuditData(CalcOpDto calcOpDto, String operation, int result) {
		return new Audit(new Date(), operation, calcOpDto.toString(), result);
	}
}
