package br.com.tinnova.vehicle.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com.tinnova")
public class VehicleManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleManagerServiceApplication.class, args);
	}

}
