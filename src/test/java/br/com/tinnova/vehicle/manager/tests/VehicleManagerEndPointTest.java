package br.com.tinnova.vehicle.manager.tests;

import br.com.tinnova.vehicle.manager.VehicleManagerServiceApplication;
import br.com.tinnova.vehicle.manager.endpoint.request.VehicleRequest;
import br.com.tinnova.vehicle.manager.repository.entity.Vehicle;
import br.com.tinnova.vehicle.manager.service.VehicleManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {VehicleManagerServiceApplication.class})
public class VehicleManagerEndPointTest {

    @Autowired
    VehicleManagerService vehicleManagerService;

    @Test
    public void saveVehicle() {
        VehicleRequest payload_1 = createPayloadForPost_1();
        final Vehicle astra = vehicleManagerService.save(payload_1);
        assertThat(astra).isNotNull();
        assertThat(astra.getId()).isNotNull();
        assertThat(astra.getVehicle()).isEqualTo("Astra");

        VehicleRequest payload_2 = createPayloadForPost_2();
        final Vehicle jetta = vehicleManagerService.save(payload_2);
        assertThat(jetta).isNotNull();
        assertThat(jetta.getId()).isNotNull();
        assertThat(jetta.getVehicle()).isEqualTo("Jetta");
    }

    @Test
    public void findAllVehicles(){
        List<Vehicle> allVehicles = vehicleManagerService.findAllVehicles();
        assertThat(allVehicles).isNotEmpty();
    }

    //Todo Criar pattern builder para criação de payload customizado
    private VehicleRequest createPayloadForPost_1(){
        VehicleRequest vehicleRequest = new VehicleRequest();
        vehicleRequest.setBrand("Chevrolet");
        vehicleRequest.setDescription("Carro Intermediario");
        vehicleRequest.setVehicle("Astra");
        vehicleRequest.setSold(true);
        vehicleRequest.setYear(2012);
        vehicleRequest.setCreated(ZonedDateTime.now());
        vehicleRequest.setUpdate(ZonedDateTime.now());
        return vehicleRequest;
    }

    private VehicleRequest createPayloadForPost_2(){
        VehicleRequest vehicleRequest = new VehicleRequest();
        vehicleRequest.setBrand("Volkswagem");
        vehicleRequest.setDescription("Carro de Luxo");
        vehicleRequest.setVehicle("Jetta");
        vehicleRequest.setSold(true);
        vehicleRequest.setYear(2015);
        vehicleRequest.setCreated(ZonedDateTime.now());
        vehicleRequest.setUpdate(ZonedDateTime.now());
        return vehicleRequest;
    }

}
