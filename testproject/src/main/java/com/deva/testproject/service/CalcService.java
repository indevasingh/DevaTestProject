package com.deva.testproject.service;

import org.springframework.stereotype.Service;

import com.deva.testproject.model.CalcOpDto;

@Service
public class CalcService {
	
	/**
     * Add x, y of calcOpDto
     * @param calcOpDto
     * @return sum of x and y as result
     */
	public Integer add(CalcOpDto calcOpDto) {
		return Math.addExact(calcOpDto.getX(), calcOpDto.getY()); 
	}
	
	
	/**
     * Subtract y from x of calcOpDto
     * @param calcOpDto
     * @return subtraction of x and y as result
     */
	public Integer sub(CalcOpDto calcOpDto) {
		return Math.subtractExact(calcOpDto.getX(), calcOpDto.getY());
	}
}
