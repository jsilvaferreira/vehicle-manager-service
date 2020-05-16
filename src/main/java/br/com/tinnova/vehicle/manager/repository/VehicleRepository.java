package br.com.tinnova.vehicle.manager.repository;


import br.com.tinnova.vehicle.manager.endpoint.request.VehicleRequest;
import br.com.tinnova.vehicle.manager.endpoint.resource.DistributionByManufacturerResource;
import br.com.tinnova.vehicle.manager.repository.converter.VehicleRepositoryConverter;
import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {

    VehicleJpaRepository vehicleJpaRepository;

    VehicleRepository(VehicleJpaRepository vehicleJpaRepository) {
        this.vehicleJpaRepository = vehicleJpaRepository;
    }

    public List<Vehicle> findAllVehicles(){
        return vehicleJpaRepository.findAll();
    }

    public Vehicle findVehicleById(long vehicleId) {
        return vehicleJpaRepository.findById(vehicleId);
    }

    @Transactional
    public void delete(Vehicle vehicle){
        vehicleJpaRepository.delete(vehicle);
        return;
    }

    @Transactional
    public Vehicle save(VehicleRequest payload) {
        return vehicleJpaRepository.save(VehicleRepositoryConverter.toEntity(payload));
    }

    @Transactional
    public Vehicle updateVehicleData(VehicleRequest payload,long vehicleId) {
        return vehicleJpaRepository.update(VehicleRepositoryConverter.toEntity(payload, vehicleId));
    }

    public long getTotalUnsoldVehicles() {
        return vehicleJpaRepository.calculatesNumberUnsoldVehicles();
    }

    public List<DistributionByManufacturerResource> getTotalVehiclesByManufacturer(){
        List<DistributionByManufacturerResource> totalVehiclesByManufacturer = new ArrayList<>();
        List<Object[]> results = vehicleJpaRepository.calculatesTotalVehiclesByManufacturer();

        for (Object[] result : results) {
            DistributionByManufacturerResource resource = new DistributionByManufacturerResource();
            resource.setBrand((String)result[0]);
            resource.setTotal((long)result[1]);
            totalVehiclesByManufacturer.add(resource);
        }
        return  totalVehiclesByManufacturer;
    }

    public Vehicle partialUpdate(Vehicle merge) {
        return vehicleJpaRepository.update(merge);
    }
}

