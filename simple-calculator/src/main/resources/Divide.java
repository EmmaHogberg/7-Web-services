package com.example.demo;

public class Divide {
	
	public static String divideTwoNumbers(String num1, String num2) {
		
		int sum = Integer.parseInt(num1) * Integer.parseInt(num2);
		String stringSum = String.valueOf(sum);
		
		return stringSum;
	}
	

}
