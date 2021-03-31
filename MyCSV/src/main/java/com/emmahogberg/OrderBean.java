package com.emmahogberg;

import java.util.Comparator;

public class OrderBean {

    private String orderDate;
    private String region;
    private String rep1;
    private String rep2;
    private String item;
    private String units;
    private String unitCost;
    private String total;


    public OrderBean(String orderDate, String region, String rep1, String rep2, String item, String units, String unitCost, String total) {
        this.orderDate = orderDate;
        this.region = region;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.item = item;
        this.units = units;
        this.unitCost = unitCost;
        this.total = total;
    }




    public String getOrderDate() {
        return orderDate;
    }

    public String getRegion() {
        return region;
    }

    public String getRep1() {
        return rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public String getItem() {
        return item;
    }

    public String getUnits() {
        return units;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public String getTotal() {
        return total;
    }
}
