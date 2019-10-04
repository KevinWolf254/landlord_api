package co.ke.proaktivio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class LandlordApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandlordApiApplication.class, args);
	}

}
