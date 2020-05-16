package br.com.tinnova.vehicle.manager.endpoint;


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

    public VehicleManagerEndPoint(VehicleManagerService vehicleManagerService) {
        this.vehicleManagerService = vehicleManagerService;
    }

    @GetMapping("/veiculos")
    public ResponseEntity<List<VehicleResource>> findAllVehicles(){
        List<Vehicle> vehicles = vehicleManagerService.findAllVehicles();
        return ResponseEntity.ok(VehicleRepositoryConverter.listFromVehicles(vehicles));
    }

    @GetMapping("/veiculos/{vehicleId}")
    public ResponseEntity<VehicleResource> findVehicleById(@PathVariable final long vehicleId){
        Vehicle vehicle = vehicleManagerService.findVehicleById(vehicleId);
        return ResponseEntity.ok(VehicleRepositoryConverter.toResource(vehicle));
    }

    @GetMapping("/veiculos/totalVendidos")
    public ResponseEntity<UnsoldVehiclesResource> getTotalUnsoldVehicles(){
        long totalUnsoldVehicles = vehicleManagerService.getTotalUnsoldVehicles();
        return ResponseEntity.ok(VehicleRepositoryConverter.toResource(totalUnsoldVehicles));
    }

    @GetMapping("/veiculos/distribuicaoPorFabricante")
    public ResponseEntity<List<DistributionByManufacturerResource>> getTotalVehiclesByManufacturer (){
        List<DistributionByManufacturerResource> totalVehiclesByManufacturer = vehicleManagerService.getTotalVehiclesByManufacturer();
        return ResponseEntity.ok(totalVehiclesByManufacturer);
    }

    //Todo Receber VehicleRequest e converter para Vehicle Entity, corrigir erro de data na hora de salvar na base
    @PostMapping("/veiculos")
    public ResponseEntity<VehicleResource> save (@RequestBody(required = true) Vehicle body){
        Vehicle vehicle = vehicleManagerService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(VehicleRepositoryConverter.toResource(vehicle));
    }

    @DeleteMapping("/veiculos/{vehicleId}")
    public ResponseEntity<Object> removeVehicle(@PathVariable final long vehicleId){
        vehicleManagerService.delete(vehicleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/veiculos")
    public ResponseEntity<VehicleResource> updateVehicleData(@RequestBody(required = true) Vehicle body){
        Vehicle vehicle = vehicleManagerService.updateVehicleData(body);
        return ResponseEntity.ok(VehicleRepositoryConverter.toResource(vehicle));
    }
}
