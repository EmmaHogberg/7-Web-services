package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoundController {
	
	@RequestMapping("/guessChar") 
	public String guessChar(char letter) {
		char chosenLetter = Alfabet.randomLetter();
		boolean match = CharCheck.match(letter, chosenLetter);
		
		String pattern = "{ \"InLetter\":\"%s\", \"ChosenLetter\":\"%s\", \"Match\": \"%s\"}";
			
		return String.format(pattern, letter, chosenLetter, match);
	}
	

}