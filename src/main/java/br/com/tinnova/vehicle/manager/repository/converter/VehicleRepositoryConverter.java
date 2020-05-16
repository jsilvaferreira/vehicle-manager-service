package br.com.tinnova.vehicle.manager.repository.converter;

import br.com.tinnova.vehicle.manager.endpoint.request.VehicleRequest;
import br.com.tinnova.vehicle.manager.endpoint.resource.UnsoldVehiclesResource;
import br.com.tinnova.vehicle.manager.endpoint.resource.VehicleResource;
import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;


import java.util.List;
import java.util.stream.Collectors;

public class VehicleRepositoryConverter {

    private static ModelMapper modelMapper = new ModelMapper();

    public static VehicleResource toResource(Vehicle vehicle){
        VehicleResource vehicleResource = new VehicleResource(vehicle);
        return vehicleResource;
    }

    public static UnsoldVehiclesResource toResource(long total){
        UnsoldVehiclesResource unsoldVehiclesResource = new UnsoldVehiclesResource(total);
        return unsoldVehiclesResource;
    }

    public static List<VehicleResource> listFromVehicles(List<Vehicle> vehicles){
        return vehicles.stream()
                .map(VehicleResource::new)
                .collect(Collectors.toList());
    }

    public static Vehicle toEntity(VehicleRequest vehicleRequest){
      return vehicleRequest != null ? modelMapper.map(vehicleRequest, Vehicle.class) : null;
    }

    public static Vehicle toEntity(VehicleRequest vehicleRequest, long vehicleId){
        Vehicle vehicle = modelMapper.map(vehicleRequest, Vehicle.class) : null;
        vehicle.setId(vehicleId);
        return vehicle;
    }
}
