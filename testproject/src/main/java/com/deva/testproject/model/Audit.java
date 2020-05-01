package com.deva.testproject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	Date time = null;
	String operation;
	String parameters;
	int result;
	
	public Audit() {}
	
	public Audit(Date time, String operation, String parameters, int result) {
		super();
		this.time = time;
		this.operation = operation;
		this.parameters = parameters;
		this.result = result;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
}
