package com.adhikari.futbol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // implies both @Configuration and @ComponentScan
public class FutbolDriver {

    public static void main(String[] args) {
        SpringApplication.run(FutbolDriver.class);
    }
}
