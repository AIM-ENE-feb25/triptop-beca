package com.example.apiTestTriptop;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTestTriptopApplication {

	public static void main(String[] args) throws UnirestException {
		HttpResponse<String> response = Unirest.get("https://booking-com15.p.rapidapi.com/api/v1/attraction/searchAttractions?id=eyJwaW5uZWRQcm9kdWN0IjoiUFJKN2RIa0FlWllaIiwidWZpIjoyMDA4ODMyNX0%3D&sortBy=trending&page=1&currency_code=EUR&languagecode=en-us")
				.header("x-rapidapi-key", "5dfe99a327mshd8c82247e13a061p1d02e7jsn6f1e6d819c00")
				.header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
				.asString();

		//System.out.println(response.getBody());

		JSONObject allAttractionsJSON = new JSONObject(response.getBody());
		JSONArray products = allAttractionsJSON.getJSONObject("data").getJSONArray("products");

		JSONObject attraction = products.getJSONObject(0);
		String name = attraction.getString("name");
		JSONObject representativePrice = attraction.getJSONObject("representativePrice");
		double price = representativePrice.getDouble("chargeAmount");

		System.out.println(name + " " + price);


	}

}
