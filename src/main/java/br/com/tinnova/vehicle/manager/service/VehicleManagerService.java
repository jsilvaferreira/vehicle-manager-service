package br.com.tinnova.vehicle.manager.service;

import br.com.tinnova.vehicle.manager.endpoint.resource.DistributionByManufacturerResource;
import br.com.tinnova.vehicle.manager.exception.error.ErrorCodes;
import br.com.tinnova.vehicle.manager.exception.handler.NotFoundException;
import br.com.tinnova.vehicle.manager.repository.VehicleRepository;
import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleManagerService {

    VehicleRepository vehicleRepository;

    public VehicleManagerService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAllVehicles();
        if (vehicles.isEmpty()) {
            throw new NotFoundException(ErrorCodes.VEHICLE_NOT_FOUND);
        }
        return vehicles;
    }

    public void delete(final long vehicleId) {
        Vehicle vehicle = findVehicleById(vehicleId);
        vehicleRepository.delete(vehicle);
        return;
    }

    public Vehicle findVehicleById(final long vehicleId){
        Vehicle vehicle = vehicleRepository.findVehicleById(vehicleId);
        if (vehicle == null) {
            throw new NotFoundException(ErrorCodes.ENTITY_NOT_FOUND);
        }
        return vehicle;
    }

    public long getTotalUnsoldVehicles() {
        return vehicleRepository.getTotalUnsoldVehicles();
    }

    public List<DistributionByManufacturerResource> getTotalVehiclesByManufacturer(){
        return vehicleRepository.getTotalVehiclesByManufacturer();
    }

    public Vehicle save(Vehicle body) {
        return vehicleRepository.save(body);
    }

    public Vehicle updateVehicleData(Vehicle body) {
        return vehicleRepository.updateVehicleData(body);
    }
}
