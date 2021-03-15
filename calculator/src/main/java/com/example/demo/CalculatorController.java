package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CalculatorController {
	
	@RequestMapping (method = RequestMethod.GET, value = "/add")
	public String addNumbers(String numbers) {
		
		List<Double> numbersList = GetEquationNumbers.returnListOfNumbers(numbers);
		
		String sum = String.valueOf(Add.addingNumbers(numbersList));
		
		return sum;
	}
	
	
	@RequestMapping (method = RequestMethod.GET, value = "/multi")
	public String multiplayNumbers(String numbers) {
		
		List<Double> numbersList = GetEquationNumbers.returnListOfNumbers(numbers);
		
		String sum = String.valueOf(Multi.multiplayNumbers(numbersList));
		
		return sum;
	}
	
	
	@RequestMapping (method = RequestMethod.GET, value = "/divide")
	public String divideNumbers(String numbers) {
		
		List<Double> numbersList = GetEquationNumbers.returnListOfNumbers(numbers);
		
		String sum = String.valueOf(Divide.divideNumbers(numbersList));
		
		return sum;
	}
	

}
