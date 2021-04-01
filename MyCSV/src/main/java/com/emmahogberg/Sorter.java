package com.emmahogberg;

import java.util.ArrayList;
import java.util.Comparator;


public class Sorter {

    private final ArrayList<OrderBean> orderBeans;

    public Sorter(ArrayList<OrderBean> orderBeans) {
        this.orderBeans = orderBeans;
    }


    // Sort by the selected column value
    public ArrayList<OrderBean> sortBy(String column) {

        switch (column) {
            case "orderId":
                orderBeans.sort(Comparator.comparing(OrderBean::getOrderId));
                break;

            case "orderDate":
                orderBeans.sort(Comparator.comparing(OrderBean::getOrderDate));
                break;

            case "region":
                orderBeans.sort(Comparator.comparing(OrderBean::getRegion));
                break;

            case "rep1":
                orderBeans.sort(Comparator.comparing(OrderBean::getRep1));
                break;

            case "rep2":
                orderBeans.sort(Comparator.comparing(OrderBean::getRep2));
                break;

            case "item":
                orderBeans.sort(Comparator.comparing(OrderBean::getItem));
                break;

            case "units":
                orderBeans.sort(Comparator.comparing(OrderBean::getUnits));
                break;

            case "unitCost":
                orderBeans.sort(Comparator.comparing(OrderBean::getUnitCost));
                break;

            case "total":
                orderBeans.sort(Comparator.comparing(OrderBean::getTotal));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + column);
        }
        return orderBeans;
    }
}
