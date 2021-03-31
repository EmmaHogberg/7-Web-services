package com.emmahogberg;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CsvController {



	@RequestMapping(value = "/showCSV", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public void showCSV(HttpServletResponse response) throws IOException {

		var csvFile = new ClassPathResource("sample.csv");

		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());

	}

	@RequestMapping(value = "/showCSVList", method = RequestMethod.GET)
	public ArrayList<String> showCSVList() {

		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : ReadCSV.getWholeSheet()) {
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}
	@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> showCSVListJSON() {

		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : ReadCSV.getWholeSheet()) {
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}

	@RequestMapping(value = "/CsvToJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String CsvToJSON() {

		return JsonPrinter.printWholeOrder(OrderLoader.getAllOrders());
	}

	@RequestMapping(value = "/showColumn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showColumn(String column) {

		ArrayList<OrderBean> orderBeans = OrderLoader.getAllOrders();


		return JsonPrinter.printColumn(column, orderBeans);


	}

	@RequestMapping(value = "/showErrors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showErrors() {



		return JsonPrinter.printErrors(OrderLoader.getAllOrders());


	}
}
