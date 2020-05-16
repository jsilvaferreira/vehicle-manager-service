package br.com.tinnova.vehicle.manager.endpoint.resource;

public class UnsoldVehiclesResource {

    public UnsoldVehiclesResource(long total) {
        this.total = total;
    }

    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
