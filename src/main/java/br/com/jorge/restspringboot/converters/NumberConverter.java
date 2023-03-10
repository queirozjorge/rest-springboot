package br.com.jorge.restspringboot.converters;

import br.com.jorge.restspringboot.exceptions.ResourceNotFoundException;

public class NumberConverter {

	public static Double convert(String number) {
		if(number == null) return 0D;
		String n = number.replaceAll(",", ".");
		try {
			return Double.valueOf(n);
		} catch (NumberFormatException e) {
			throw new ResourceNotFoundException("Please, set a numeric value!");
		}
	}
	
}
