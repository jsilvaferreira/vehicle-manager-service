package br.com.tinnova.vehicle.manager.endpoint.request;

import java.time.ZonedDateTime;

public class VehicleRequest {

    private String vehicle;
    private String brand;
    private Integer year;
    private String description;
    private boolean sold;
    private ZonedDateTime created;
    private ZonedDateTime update;

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getUpdate() {
        return update;
    }

    public void setUpdate(ZonedDateTime update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "VehicleRequest{" +
                "vehicle='" + vehicle + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", sold=" + sold +
                ", created=" + created +
                ", update=" + update +
                '}';
    }
}
