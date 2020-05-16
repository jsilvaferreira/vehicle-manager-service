package br.com.tinnova.vehicle.manager.endpoint;

import br.com.tinnova.vehicle.manager.config.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleManagerEndPointIT extends TestConfig {

    @Test
    public void findAllVehicles(){


    }
}
