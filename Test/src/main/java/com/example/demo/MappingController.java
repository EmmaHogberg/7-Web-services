package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {
	
	@RequestMapping("/def")
	public String RequestDefault() {
		return "THIS IS @RequestMapping default to Get";
	}
	
	@RequestMapping(path="/get", method=RequestMethod.GET)
	public String RequestGetPath() {
		return "THIS IS @RequestMapping set to be Get with path";
	}
	
	@RequestMapping(value={"/getVal", "/moreVal"}, method=RequestMethod.GET)
	public String RequestGetValue() {
		return "THIS IS @RequestMapping set to be Get with value";
	}
	
	@GetMapping("/getOnly")
	public String RequestGetMap() {
		return "THIS IS @GetMapping";
	}
	
	@RequestMapping(path="/allMethod", method= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
	public String RequestMore() {
		return "THIS IS @RequestMapping set to Get/Post/Put/Delete";
	}
	
	@GetMapping("/para")
	public String RequestParams(@RequestParam String name) {
		return "name = " + name;
	}
	
	@GetMapping("/paraDef")
	public String RequestDef(@RequestParam(defaultValue = "000") String name) {
		return "name = " + name;
	}
	
	@RequestMapping(path="/two", method= RequestMethod.GET)
	public double two(int first, int second) {
		return first + second;
	}
	
	@RequestMapping(path="/more", method= RequestMethod.GET)
	public String ArrInt(@RequestParam ArrayList<String> value) {
		return value.toString();
	}

}
