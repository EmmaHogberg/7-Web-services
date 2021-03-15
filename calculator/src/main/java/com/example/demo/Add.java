package com.example.demo;

import java.util.List;

public class Add {
	
	public static double addingNumbers(List<Double> numbersList) {
		
		int sum = 0;
		
		for(double num : numbersList) {
			
			sum += num;
		}
		
		return sum;
		
	}

}
