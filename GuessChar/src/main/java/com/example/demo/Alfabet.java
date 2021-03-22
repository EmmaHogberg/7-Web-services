package com.example.demo;

import java.util.Random;

public class Alfabet {
	
	public final static char[] ALPHABET = {
			
	}
	
	
	public static char randomLetter() {
		Random random = new Random();
		int ranNumber = random.nextInt(ALPHABET.length);
		char letter = ALPHABET[ranNumber];
		
		return letter;
	}

}
