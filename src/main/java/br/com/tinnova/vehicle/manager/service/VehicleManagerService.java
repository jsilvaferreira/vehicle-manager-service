package br.com.tinnova.vehicle.manager.service;

import br.com.tinnova.vehicle.manager.endpoint.resource.DistributionByManufacturerResource;
import br.com.tinnova.vehicle.manager.exception.BadRequestException;
import br.com.tinnova.vehicle.manager.exception.NotFoundException;
import br.com.tinnova.vehicle.manager.exception.error.ErrorCodes;
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

    public Vehicle save(Vehicle payload) {
        if (payload == null){
            throw new BadRequestException(ErrorCodes.PAYLOAD_IS_MANDATORY);
        }
        return vehicleRepository.save(payload);
    }

    public Vehicle updateVehicleData(Vehicle payload, long vehicleId) {
        if (payload == null){
            throw new BadRequestException(ErrorCodes.PAYLOAD_IS_MANDATORY);
        }
        return vehicleRepository.updateVehicleData(payload, vehicleId);
    }

    public Vehicle partialUpdate(Vehicle payload, Vehicle existingVehicle, long vehicleId) {
        if (payload == null){
            throw new BadRequestException(ErrorCodes.PAYLOAD_IS_MANDATORY);
        }
        return vehicleRepository.partialUpdate(merge(payload,existingVehicle), vehicleId);
    }

    private Vehicle merge (Vehicle payload, Vehicle existingVehicle){
        if (payload.getBrand() != null){
            existingVehicle.setBrand(payload.getBrand());
        } else if (payload.getCreated() != null){
            existingVehicle.setCreated(payload.getCreated());
        } else if (payload.getDescription() != null){
            existingVehicle.setDescription(payload.getDescription());
        } else if (payload.getUpdate() != null){
            existingVehicle.setUpdate(payload.getUpdate());
        } else if (payload.getVehicle() != null){
            existingVehicle.setVehicle(payload.getVehicle());
        } else if (payload.getYear() != null){
            existingVehicle.setYear(payload.getYear());
        }
        return existingVehicle;
    }
}
