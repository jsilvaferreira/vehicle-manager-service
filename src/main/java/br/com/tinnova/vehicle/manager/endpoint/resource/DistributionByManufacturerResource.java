package br.com.tinnova.vehicle.manager.endpoint.resource;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"brand", "total"})
public class DistributionByManufacturerResource {

    private String brand;
    private long total;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}