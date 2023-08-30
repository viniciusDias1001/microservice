package io.github.ViniciusDias1001.NameServe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NameServeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NameServeApplication.class, args);
	}

}
