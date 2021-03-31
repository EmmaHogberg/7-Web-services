package com.emmahogberg;

import java.math.BigDecimal;
import java.util.ArrayList;


public class JsonPrinter {




    // Method to print the whole order as a Json
    public static String printWholeOrder(ArrayList<OrderBean> orderBeans) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (OrderBean order : orderBeans) {

            String pattern = "{\"order\":{\"orderDate\": \"%s\", \"region\": \"%s\", \"rep1\": \"%s\", \"rep2\": \"%s\", " +
                    "\"item\": \"%s\", \"units\":%s, \"unitCost\":%s, \"total\":%s}},";

            stringBuilder.append(String.format(pattern, order.orderDate, order.region, order.rep1, order.rep2,
                    order.item, order.units, order.unitCost, order.total));
        }
        // Remove last comma
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    // Method to print one column of the order as a Json
    public static String printColumn(String column, ArrayList<OrderBean> orderBeans) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (OrderBean order : orderBeans) {

            String value = "";

            switch (column) {
                case "orderDate":
                    value = order.orderDate;
                    break;

                case "region":
                    value = order.region;
                    break;

                case "rep1":
                    value = order.rep1;
                    break;

                case "rep2":
                    value = order.rep2;
                    break;

                case "item":
                    value = order.item;
                    break;

                case "units":
                    value = order.units;
                    break;

                case "unitCost":
                    value = order.unitCost;
                    break;

                case "total":
                    value = order.total;
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + column);
            }

            String pattern = "{\"order\":{\"%s\": \"%s\"}},";
            stringBuilder.append(String.format(pattern, column, value));
        }
        // Remove last comma
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append("]");
        return stringBuilder.toString();
    }




    // Method to print all errors of the whole order as a Json
    public static String printErrors(ArrayList<OrderBean> orderBeans) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (OrderBean order : orderBeans) {

            BigDecimal units = new BigDecimal(order.units);
            BigDecimal unitCost = new BigDecimal(order.unitCost);
            BigDecimal total = new BigDecimal(order.total);

            if (!units.multiply(unitCost).equals(total)) {

                String pattern = "{\"order\":{\"orderDate\": \"%s\", \"region\": \"%s\", \"rep1\": \"%s\", " +
                        "\"rep2\": \"%s\", \"item\": \"%s\", \"units\":%s, \"unitCost\":%s, \"total\":%s}},";

                stringBuilder.append(String.format(pattern, order.orderDate, order.region, order.rep1,
                        order.rep2, order.item, order.units, order.unitCost, order.total));
            }
        }
        // Remove last comma
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append("]");
        return stringBuilder.toString();
    }




//
//    private static String patternPrinter() {
//
//
//
//    }
}
