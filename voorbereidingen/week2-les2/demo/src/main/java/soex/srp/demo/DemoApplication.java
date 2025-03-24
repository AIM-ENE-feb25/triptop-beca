package soex.srp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Product product1 = new Product(1, "Apple", 10.50);
		Product product2 = new Product(2, "Banana", 11.50);
		Basket basket = new Basket(1, Arrays.asList(product1, product2));
		Console console = new Console();

		console.printBasket(basket);
	}

}
