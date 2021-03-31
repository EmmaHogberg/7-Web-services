package com.emmahogberg;

import java.math.BigDecimal;
import java.util.ArrayList;


public class JsonPrinter {




    // Method to print the whole order as a Json
    public static String printWholeOrder(ArrayList<OrderBean> orderBeans) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (OrderBean order : orderBeans) {

            stringBuilder.append(formatOrderToJson(order));
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

            BigDecimal units = new BigDecimal(order.getUnits());
            BigDecimal unitCost = new BigDecimal(order.getUnitCost());
            BigDecimal total = new BigDecimal(order.getTotal());

            if (!units.multiply(unitCost).equals(total)) {

                stringBuilder.append(formatOrderToJson(order));
            }
        }
        // Remove last comma
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        stringBuilder.append("]");
        return stringBuilder.toString();
    }



    // Pattern to print Json
    private static String formatOrderToJson(OrderBean order) {
        String pattern = "{\"order\":{\"orderDate\": \"%s\", \"region\": \"%s\", \"rep1\": \"%s\", \"rep2\": \"%s\", " +
                "\"item\": \"%s\", \"units\":%s, \"unitCost\":%s, \"total\":%s}},";

        return String.format(pattern, order.getOrderDate(), order.getRegion(), order.getRep1(), order.getRep2(),
                order.getItem(), order.getUnits(), order.getUnitCost(), order.getTotal());
    }




    // Method to print one column of the order as a Json
    public static String printColumn(String column, ArrayList<OrderBean> orderBeans) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (OrderBean order : orderBeans) {

            String value = "";

            switch (column) {
                case "orderDate":
                    value = order.getOrderDate();
                    break;

                case "region":
                    value = order.getRegion();
                    break;

                case "rep1":
                    value = order.getRep1();
                    break;

                case "rep2":
                    value = order.getRep2();
                    break;

                case "item":
                    value = order.getItem();
                    break;

                case "units":
                    value = order.getUnits();
                    break;

                case "unitCost":
                    value = order.getUnitCost();
                    break;

                case "total":
                    value = order.getTotal();
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
}
