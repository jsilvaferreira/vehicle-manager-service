package br.com.tinnova.vehicle.manager.repository.entity;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name="VEHICLE")
    private String vehicle;

    @Column(name="BRAND")
    private String brand;

    @Column(name="YEAR")
    private Integer year;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(columnDefinition="tinyint(1) default 1")
    private boolean sold;

    private ZonedDateTime created;

    private ZonedDateTime updated;

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

    public boolean getSold() {
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

    public void setUpdate(ZonedDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicle='" + vehicle + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", sold=" + sold +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
