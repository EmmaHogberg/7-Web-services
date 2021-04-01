package com.emmahogberg;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;



@RestController
public class CsvController {


	@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> showCSVListJSON() {


		ArrayList<String> SimpleCsv= new ArrayList<String>();

		for (ArrayList<String> row : ReadCSV.getWholeSheet()) {

			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}

	// Method for displaying CSV-document as JSON (G)
	@RequestMapping(value = "/showCsvAsJson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showCsvAsJson() {

		return JsonPrinter.printWholeOrder(OrderLoader.getAllOrders());
	}


	//Method for displaying the selected column (G)
	@RequestMapping(value = "/showColumn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showColumn(String column) {

		return JsonPrinter.printColumn(column, OrderLoader.getAllOrders());
	}


	//Method for displaying the selected column sorted alphanumerically (VG)
	@RequestMapping(value = "/showSortedColumn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showSortedColumn(String column) {

		ArrayList<OrderBean> orderBeans = new ArrayList<>(OrderLoader.getAllOrders());
		Sorter sorter = new Sorter(orderBeans);
		ArrayList<OrderBean> sortedOrderBeans = sorter.sortBy(column);

		return JsonPrinter.printColumn(column, sortedOrderBeans);
	}


	//Method for displaying the whole CSV sorted by selected column (Super-bonus)
	@RequestMapping(value = "/showAllSortedByColumn", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showAllSortedByColumn(String column) {

		ArrayList<OrderBean> orderBeans = new ArrayList<>(OrderLoader.getAllOrders());
		Sorter sorter = new Sorter(orderBeans);
		ArrayList<OrderBean> sortedOrderBeans = sorter.sortBy(column);

		return JsonPrinter.printWholeOrder(sortedOrderBeans);
	}


	//Method for displaying the rows that have the wrong sums for units, unitCost and total (G)
	@RequestMapping(value = "/showErrors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showErrors() {

		return JsonPrinter.printErrors(OrderLoader.getAllOrders());
	}
}
