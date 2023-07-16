package com.example.loconav.flightmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightManagementSystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(FlightManagementSystemApplication.class, args);
		System.out.println("SERVER STARTED ON PORT 5000");
	}

}
