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

    public VehicleRepository(VehicleJpaRepository vehicleJpaRepository, VehicleRepositoryConverter vehicleRepositoryConverter) {
        this.vehicleJpaRepository = vehicleJpaRepository;
        this.vehicleRepositoryConverter = vehicleRepositoryConverter;
    }

    VehicleRepositoryConverter vehicleRepositoryConverter;

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
        return vehicleJpaRepository.save(vehicleRepositoryConverter.toEntity(payload));
    }

    @Transactional
    public Vehicle updateVehicleData(VehicleRequest payload,long vehicleId) {
        return vehicleJpaRepository.save(vehicleRepositoryConverter.toEntity(payload, vehicleId));
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

    public Vehicle partialUpdate(VehicleRequest payload, Vehicle existingVehicle, long vehicleId) {
        return vehicleJpaRepository.save(merge(payload,existingVehicle,vehicleId));
    }

    private Vehicle merge (VehicleRequest payload, Vehicle existingVehicle, long vehicleId){
        if (payload.getBrand() != null){
            existingVehicle.setBrand(payload.getBrand());
        }
        if (payload.getCreated() != null){
            existingVehicle.setCreated(payload.getCreated());
        }
        if (payload.getDescription() != null){
            existingVehicle.setDescription(payload.getDescription());
        }
        if (payload.getUpdate() != null){
            existingVehicle.setUpdate(payload.getUpdate());
        }
        if (payload.getVehicle() != null){
            existingVehicle.setVehicle(payload.getVehicle());
        }
        if (payload.getYear() != null){
            existingVehicle.setYear(payload.getYear());
        }
        existingVehicle.setId(vehicleId);
        return existingVehicle;
    }
}

