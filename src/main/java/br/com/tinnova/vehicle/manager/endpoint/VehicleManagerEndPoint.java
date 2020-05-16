package br.com.tinnova.vehicle.manager.endpoint;


import br.com.tinnova.vehicle.manager.endpoint.request.VehicleRequest;
import br.com.tinnova.vehicle.manager.endpoint.resource.DistributionByManufacturerResource;
import br.com.tinnova.vehicle.manager.endpoint.resource.UnsoldVehiclesResource;
import br.com.tinnova.vehicle.manager.endpoint.resource.VehicleResource;
import br.com.tinnova.vehicle.manager.repository.converter.VehicleRepositoryConverter;
import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import br.com.tinnova.vehicle.manager.service.VehicleManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleManagerEndPoint {

    VehicleManagerService vehicleManagerService;
    VehicleRepositoryConverter vehicleRepositoryConverter;

    public VehicleManagerEndPoint(VehicleManagerService vehicleManagerService, VehicleRepositoryConverter vehicleRepositoryConverter) {
        this.vehicleManagerService = vehicleManagerService;
        this.vehicleRepositoryConverter = vehicleRepositoryConverter;
    }

    @GetMapping("/veiculos")
    public ResponseEntity<List<VehicleResource>> findAllVehicles(){
        List<Vehicle> vehicles = vehicleManagerService.findAllVehicles();
        return ResponseEntity.ok(vehicleRepositoryConverter.listFromVehicles(vehicles));
    }

    @GetMapping("/veiculos/{vehicleId}")
    public ResponseEntity<VehicleResource> findVehicleById(@PathVariable final long vehicleId){
        Vehicle vehicle = vehicleManagerService.findVehicleById(vehicleId);
        return ResponseEntity.ok(vehicleRepositoryConverter.toResource(vehicle));
    }

    @GetMapping("/veiculos/vendidos")
    public ResponseEntity<UnsoldVehiclesResource> getTotalUnsoldVehicles(){
        long totalUnsoldVehicles = vehicleManagerService.getTotalUnsoldVehicles();
        return ResponseEntity.ok(vehicleRepositoryConverter.toResource(totalUnsoldVehicles));
    }

    @GetMapping("/veiculos/distribuicaoPorFabricante")
    public ResponseEntity<List<DistributionByManufacturerResource>> getTotalVehiclesByManufacturer (){
        List<DistributionByManufacturerResource> totalVehiclesByManufacturer = vehicleManagerService.getTotalVehiclesByManufacturer();
        return ResponseEntity.ok(totalVehiclesByManufacturer);
    }

    //Todo Receber VehicleRequest e converter para Vehicle Entity, corrigir erro de data na hora de salvar na base
    @PostMapping("/veiculos")
    public ResponseEntity<VehicleResource> save (@RequestBody(required = true) VehicleRequest payload){
        Vehicle vehicle = vehicleManagerService.save(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleRepositoryConverter.toResource(vehicle));
    }

    @DeleteMapping("/veiculos/{vehicleId}")
    public ResponseEntity<Object> removeVehicle(@PathVariable("vehicleId") final long vehicleId){
        vehicleManagerService.delete(vehicleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/veiculos/{vehicleId}")
    public ResponseEntity<VehicleResource> updateVehicleData(
            @PathVariable("vehicleId") final Long vehicleId,
            @RequestBody final VehicleRequest payload){
        Vehicle vehicle = vehicleManagerService.updateVehicleData(payload, vehicleId);
        return ResponseEntity.ok(vehicleRepositoryConverter.toResource(vehicle));
    }

    @PatchMapping("/veiculos/{vehicleId}")
    public ResponseEntity<VehicleResource> partialUpdate(
            @PathVariable("vehicleId") final Long vehicleId,
            @RequestBody final VehicleRequest payload){
        Vehicle existingVehicle = vehicleManagerService.findVehicleById(vehicleId);
        Vehicle vehicle = vehicleManagerService.partialUpdate(payload, existingVehicle, vehicleId);
        return ResponseEntity.ok(vehicleRepositoryConverter.toResource(vehicle));
    }
}
