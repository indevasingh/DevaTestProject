package com.deva.testproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deva.testproject.constants.CalcConstants.Operation;
import com.deva.testproject.model.CalcOpDto;

@Service
public class CalcService {
	
	@Autowired
	private AuditService auditService;
	
	/**
     * Add x, y of calcOpDto
     * @param calcOpDto
     * @return sum of x and y as result
     */
	public Integer add(CalcOpDto calcOpDto) {
		Integer result = Math.addExact(calcOpDto.getX(), calcOpDto.getY()); 
		auditService.createAuditRecord(calcOpDto, Operation.ADDITION, result);
		return result;
	}
	
	
	/**
     * Subtract y from x of calcOpDto
     * @param calcOpDto
     * @return subtraction of x and y as result
     */
	public Integer sub(CalcOpDto calcOpDto) {
		Integer result = Math.subtractExact(calcOpDto.getX(), calcOpDto.getY());
		auditService.createAuditRecord(calcOpDto, Operation.SUBTRACTION, result);
		return result;
	}
}
