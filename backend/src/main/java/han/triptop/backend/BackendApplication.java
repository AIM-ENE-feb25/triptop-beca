package han.triptop.backend;

import han.triptop.backend.controller.FlightController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mashape.unirest.http.exceptions.UnirestException;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

		FlightController flightController = new FlightController();
		try {
			flightController.getFlights();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}
}