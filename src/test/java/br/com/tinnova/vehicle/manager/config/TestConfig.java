package br.com.tinnova.vehicle.manager.config;

import org.springframework.boot.web.server.LocalServerPort;

public class TestConfig {

    @LocalServerPort
    public int port;

    public int getPort() {
        return port;
    }
}
