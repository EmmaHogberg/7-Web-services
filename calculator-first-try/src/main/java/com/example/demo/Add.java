package com.example.demo;

public class Add {
	
	public static String addTwoNumbers(String num1, String num2) {
		
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		String stringSum = String.valueOf(sum);
		
		return stringSum;
		
	}

}
