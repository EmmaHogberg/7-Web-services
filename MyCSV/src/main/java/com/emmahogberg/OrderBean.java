package com.emmahogberg;

public class OrderBean {

    private String orderDate;
    private String region;
    private String rep1;
    private String rep2;
    private String item;
    private Double units;
    private Double unitCost;
    private Double total;


    public OrderBean(String orderDate, String region, String rep1, String rep2, String item, Double units, Double unitCost, Double total) {
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

    public Double getUnits() {
        return units;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public Double getTotal() {
        return total;
    }
}
