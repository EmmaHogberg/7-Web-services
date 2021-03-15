package com.example.demo;

import java.util.List;

public class Multi {
	
	public static double multiplayNumbers(List<Double> numbersList) {
		
		double sum = numbersList.get(0);
		
		for(int i = 1; i < numbersList.size(); i++) {
			
			sum *= numbersList.get(i);
		}
		
		return sum;
	}


}
