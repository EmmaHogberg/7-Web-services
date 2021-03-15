package com.example.demo;

import java.util.List;

public class Divide {
	
	public static double divideNumbers(List<Double> numbersList) {
		
		double sum = numbersList.get(0);
		
		for(int i = 1; i < numbersList.size(); i++) {
			
			sum /= numbersList.get(i);
		}
		
		return sum;
	}

}
