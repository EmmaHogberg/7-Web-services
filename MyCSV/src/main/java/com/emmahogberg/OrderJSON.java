package com.emmahogberg;

import java.util.ArrayList;

public class OrderJSON(ArrayList<ArrayList<String>> csvArrayList) {
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
