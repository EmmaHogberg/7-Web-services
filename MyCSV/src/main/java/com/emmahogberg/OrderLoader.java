package com.emmahogberg;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class OrderLoader {
    private static final DateFormat orderDateFormatter = new SimpleDateFormat("MM/dd/yyyy");
    private static final ArrayList<OrderBean> orderBeans = new ArrayList<>();


    // Check if orderBean is loaded, if not load it, and return orderBean
    public static ArrayList<OrderBean> getAllOrders() {

        if (orderBeans.isEmpty()) {
            loadAll();
        }
        return orderBeans;
    }


    // Load all info from CSV to orderBean
    private static void loadAll() {

        for (int i = 1; i < ReadCSV.getWholeSheet().size(); i++) {

            //Format orderDate to Date
            Date orderDate = null;
            try {
                orderDate = orderDateFormatter.parse(ReadCSV.getWholeSheet().get(i).get(1));
            }catch (ParseException e) {
                e.printStackTrace();
            }


            OrderBean order = new OrderBean(Integer.parseInt(ReadCSV.getWholeSheet().get(i).get(0)),
                    orderDate, ReadCSV.getWholeSheet().get(i).get(2),
                    ReadCSV.getWholeSheet().get(i).get(3), ReadCSV.getWholeSheet().get(i).get(4),
                    ReadCSV.getWholeSheet().get(i).get(5), new BigDecimal((ReadCSV.getWholeSheet().get(i).get(6))),
                    new BigDecimal(ReadCSV.getWholeSheet().get(i).get(7)),
                    new BigDecimal(ReadCSV.getWholeSheet().get(i).get(8)));

            orderBeans.add(order);
        }
    }
}
