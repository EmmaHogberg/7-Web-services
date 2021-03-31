package com.emmahogberg;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;



@RestController
public class CsvController {


//
//	@RequestMapping(value = "/showCSV", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
//	public void showCSV(HttpServletResponse response) throws IOException {
//
//		var csvFile = new ClassPathResource("sample.csv");
//
//		response.setContentType(MediaType.TEXT_PLAIN_VALUE);
//		StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
//
//	}
//
//	@RequestMapping(value = "/showCSVList", method = RequestMethod.GET)
//	public ArrayList<String> showCSVList() {
//
//		ArrayList<String> SimpleCsv= new ArrayList<String>();
//
//		for (ArrayList<String> row : ReadCSV.getWholeSheet()) {
//
//			SimpleCsv.addAll(row);
//		}
//		return SimpleCsv;
//
//	}
//	@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ArrayList<String> showCSVListJSON() {
//
//		ArrayList<String> SimpleCsv= new ArrayList<String>();
//
//		for (ArrayList<String> row : ReadCSV.getWholeSheet()) {
//
//			SimpleCsv.addAll(row);
//		}
//		return SimpleCsv;
//	}
//
//




	@RequestMapping(value = "/CsvToJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String CsvToJSON() {

		return JsonPrinter.printWholeOrder(OrderLoader.getAllOrders());
	}






	@RequestMapping(value = "/showColumn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showColumn(String column) {

		ArrayList<OrderBean> orderBeans = new ArrayList<>(OrderLoader.getAllOrders());
		Sorter sorter = new Sorter(orderBeans);
		ArrayList<OrderBean> sortedOrderBeans = sorter.sortBy(column);

		return JsonPrinter.printColumn(column, sortedOrderBeans);
	}







	@RequestMapping(value = "/showSortedByColumn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showSortedByColumn(String column) {

		ArrayList<OrderBean> orderBeans = new ArrayList<>(OrderLoader.getAllOrders());
		Sorter sorter = new Sorter(orderBeans);
		ArrayList<OrderBean> sortedOrderBeans = sorter.sortBy(column);

		return JsonPrinter.printWholeOrder(sortedOrderBeans);
	}




	@RequestMapping(value = "/showErrors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showErrors() {

		return JsonPrinter.printErrors(OrderLoader.getAllOrders());
	}
}
