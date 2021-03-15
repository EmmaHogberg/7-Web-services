package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetEquationNumbers {
	
	public static List<Double> returnListOfNumbers(String numbers) {
		
		String stringNumbers[] = numbers.split(",");
		List<String> stringNumbersList = new ArrayList<String>();
		stringNumbersList = Arrays.asList(stringNumbers);
		
		List<Double> intNumbersList = new ArrayList<Double>();
		
		for(String num : stringNumbersList) {
			intNumbersList.add(Double.valueOf(num));
		}
		
		return intNumbersList;
		
	}

}
