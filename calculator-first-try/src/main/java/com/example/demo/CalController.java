package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalController {
	
	
	@RequestMapping (method = RequestMethod.GET, value = "/add")
	public String addNum(String num1, String num2) {
		
		return Add.addTwoNumbers(num1, num2);
	}
	
	
	@RequestMapping (method = RequestMethod.GET, value = "/multi")
	public String multiNum(String multi1, String multi2) {
		
		return Multi.multiplyTwoNumbers(multi1, multi2);
	}
	
	
	@RequestMapping (method = RequestMethod.GET, value = "/divide")
	public String divideNum(String divide1, String divide2) {
		
		return Divide.divideTwoNumbers(divide1, divide2);
	}
	
}
