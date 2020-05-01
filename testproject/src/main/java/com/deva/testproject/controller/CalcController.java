package com.deva.testproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deva.testproject.model.AuditResult;
import com.deva.testproject.model.CalcOpDto;
import com.deva.testproject.model.CalcResult;
import com.deva.testproject.service.AuditService;
import com.deva.testproject.service.CalcService;

@RestController
@RequestMapping("/api")
public class CalcController {
	
	@Autowired
	private CalcService calcService;
	
	@Autowired
	private AuditService auditService;
	
	
	/**
     * Add x, y of calcOpDto
     * @param calcOpDto
     * @return CalcResult
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CalcResult add(@RequestBody CalcOpDto calcOpDto) {
		Integer result = calcService.add(calcOpDto);
		return new CalcResult(result.toString());
	}
	
	/**
     * Subtracts y form x, of calcOpDto
     * @param calcOpDto
     * @return CalcResult
     */
	@RequestMapping(value = "/diff", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CalcResult diff(@RequestBody CalcOpDto calcOpDto) {
		Integer result = calcService.sub(calcOpDto);
		return new CalcResult(result.toString());
	}
	
	/**
     * Secured: Add x, y of calcOpDto
     * Requires: Basic Authentication to consume this API.
     * @param calcOpDto
     * @return CalcResult
     */
	@RequestMapping(value = "/secured/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CalcResult securedAdd(@RequestBody CalcOpDto calcOpDto) {
		Integer result = calcService.add(calcOpDto);
		return new CalcResult(result.toString()); 
	}
	
	/**
     * Secured: Subtracts y form x, of calcOpDto
     * Requires: Basic Authentication to consume this API.
     * @param calcOpDto
     * @return CalcResult
     */
	@RequestMapping(value = "/secured/diff", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public CalcResult securedDiff(@RequestBody CalcOpDto calcOpDto) {
		Integer result = calcService.sub(calcOpDto);
		return new CalcResult(result.toString());
	}
	
	/**
     * To get all Audit (transactions) records
     * @return AuditResult
     */
	@GetMapping("/transactions")
	public AuditResult getTransaction() {
		return auditService.getAuditResult();
	}
}
