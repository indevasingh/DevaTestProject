package com.deva.testproject.model;

import java.util.ArrayList;
import java.util.List;

public class AuditResult {
	List<Audit> auditResult = new ArrayList<Audit>();
	
	public AuditResult() {}
	
	public AuditResult(List<Audit> auditResult) {
		this.auditResult = auditResult;
	}
	
	public List<Audit> getAuditResult() {
		return auditResult;
	}
}
