package br.com.jorge.restspringboot.controllers;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.jorge.restspringboot.converters.NumberConverter;
import br.com.jorge.restspringboot.exceptions.ResourceNotFoundException;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double getSum(
			@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {
			return new BigDecimal(NumberConverter.convert(numberOne))
								.add(new BigDecimal(NumberConverter.convert(numberTwo)))
								.doubleValue();
	}
	
	@GetMapping("/subtract/{numberOne}/{numberTwo}")
	public Double getSubtract(
			@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {
			return new BigDecimal(NumberConverter.convert(numberOne))
								.subtract(new BigDecimal(NumberConverter.convert(numberTwo)))
								.doubleValue();
	}
	
	@GetMapping("/multiply/{numberOne}/{numberTwo}")
	public Double getMultiply(
			@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {
			return new BigDecimal(NumberConverter.convert(numberOne))
								.multiply(new BigDecimal(NumberConverter.convert(numberTwo)))
								.doubleValue();
	}
	
	@GetMapping("/divide/{numberOne}/{numberTwo}")
	public Double getDivide(
			@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {
		if(numberTwo.equals("0")) {
			throw new ResourceNotFoundException("Cannot divide by zero!");
		}
			return new BigDecimal(NumberConverter.convert(numberOne))
								.divide(new BigDecimal(NumberConverter.convert(numberOne)))
								.doubleValue();
	}
	
	@GetMapping("/squareRoot/{number}")
	public Double getSquareRoot(
			@PathVariable(name = "number") String number) {
			return new BigDecimal(NumberConverter.convert(number))
								.sqrt(new MathContext(10))
								.doubleValue();
	}
	
}
