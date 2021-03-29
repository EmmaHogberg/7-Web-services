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
		
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}
	@RequestMapping(value = "/showCSVListJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<String> showCSVListJSON() {

		ArrayList<String> SimpleCsv= new ArrayList<String>();
		
		for (ArrayList<String> row : readCSV.getWholeSheet()) {
			
			SimpleCsv.addAll(row);
		}
		return SimpleCsv;

	}

	@RequestMapping(value = "/showCSVstuff", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showCSVstuff() {

		ArrayList<String> stuff = new ArrayList<>();

		OrderBean order = null;

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 1; i < readCSV.getWholeSheet().size(); i++) {

			order = new OrderBean(readCSV.getWholeSheet().get(i).get(1),
					readCSV.getWholeSheet().get(i).get(2), readCSV.getWholeSheet().get(i).get(3),
					readCSV.getWholeSheet().get(i).get(4), readCSV.getWholeSheet().get(i).get(5),
					readCSV.getWholeSheet().get(i).get(6), readCSV.getWholeSheet().get(i).get(7),
					readCSV.getWholeSheet().get(i).get(8));

			String pattern = "{ \"order\":%s {\"orderDate\":%s, \"region\":%s, \"rep1\":%s, \"rep2\":%s, \"item\":%s, \"units\":%s, \"unitCost\":%s, \"total\":%s},}";
			stringBuilder.append(String.format(pattern, i, order.orderDate, order.region, order.rep1, order.rep2, order.item, order.units, order.unitCost, order.total));
		}

		return stringBuilder.toString();
	}

}
