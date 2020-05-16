package br.com.tinnova.vehicle.manager.repository;

import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VehicleJpaRepository extends Repository<Vehicle, Long> {

    List<Vehicle> findAll();

    Vehicle findById(long vehicleId);

    void delete(Vehicle vehicle);

    Vehicle save(Vehicle payload);

    @Query("Select count(v) from Vehicle v where v.sold = true")
    long calculatesNumberUnsoldVehicles();

    @Query("select brand, count(*) as total from Vehicle group by brand")
    List<Object[]> calculatesTotalVehiclesByManufacturer();

}