package br.com.tinnova.vehicle.manager.repository.converter;

import br.com.tinnova.vehicle.manager.endpoint.request.VehicleRequest;
import br.com.tinnova.vehicle.manager.endpoint.resource.UnsoldVehiclesResource;
import br.com.tinnova.vehicle.manager.endpoint.resource.VehicleResource;
import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleRepositoryConverter {

    ModelMapper modelMapper;

    public VehicleRepositoryConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VehicleResource toResource(Vehicle vehicle){
        VehicleResource vehicleResource = new VehicleResource(vehicle);
        return vehicleResource;
    }

    public  UnsoldVehiclesResource toResource(long total){
        UnsoldVehiclesResource unsoldVehiclesResource = new UnsoldVehiclesResource(total);
        return unsoldVehiclesResource;
    }

    public List<VehicleResource> listFromVehicles(List<Vehicle> vehicles){
        return vehicles.stream()
                .map(VehicleResource::new)
                .collect(Collectors.toList());
    }

    public  Vehicle toEntity(VehicleRequest vehicleRequest){
      return vehicleRequest != null ? modelMapper.map(vehicleRequest, Vehicle.class) : null;
    }

    public Vehicle toEntity(VehicleRequest vehicleRequest, long vehicleId){
        Vehicle vehicle = modelMapper.map(vehicleRequest, Vehicle.class);
        vehicle.setId(vehicleId);
        return vehicle;
    }
}
