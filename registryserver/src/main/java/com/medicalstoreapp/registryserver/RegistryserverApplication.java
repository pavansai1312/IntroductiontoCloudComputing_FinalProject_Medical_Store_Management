package com.medicalstoreapp.registryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Pavan Sai
 *
 *         Main Class for Registry Server
 */

@EnableEurekaServer
@SpringBootApplication
public class RegistryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryserverApplication.class, args);
	}

}
