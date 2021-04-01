package com.emmahogberg;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;


public class OrderLoader {

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

            OrderBean order = new OrderBean(Integer.parseInt(ReadCSV.getWholeSheet().get(i).get(0)),
                    ReadCSV.getWholeSheet().get(i).get(1), ReadCSV.getWholeSheet().get(i).get(2),
                    ReadCSV.getWholeSheet().get(i).get(3), ReadCSV.getWholeSheet().get(i).get(4),
                    ReadCSV.getWholeSheet().get(i).get(5), new BigDecimal((ReadCSV.getWholeSheet().get(i).get(6))),
                    new BigDecimal(ReadCSV.getWholeSheet().get(i).get(7)),
                    new BigDecimal(ReadCSV.getWholeSheet().get(i).get(8)));

            orderBeans.add(order);
        }
    }
}
