package br.com.tinnova.vehicle.manager.endpoint.resource;

import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "vehicle",
        "brand",
        "year",
        "description",
        "sold",
        "created",
        "updated"
})
public class VehicleResource {

    private long id;
    private String vehicle;
    private String brand;
    private Integer year;
    private String description;
    private boolean sold;
    private ZonedDateTime created;
    private ZonedDateTime updated;

    public VehicleResource(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.vehicle = vehicle.getVehicle();
        this.brand = vehicle.getBrand();
        this.year = vehicle.getYear();
        this.description = vehicle.getDescription();
        this.sold = vehicle.getSold();
        this.created = vehicle.getCreated();
        this.updated = vehicle.getUpdate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return updated;
    }

    public void setUpdate(ZonedDateTime update) {
        this.updated = updated;
    }
}
