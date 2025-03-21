package com.example.voorbereidingLes3SoEx;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoorbereidingLes3SoExApplication {

	public static void main(String[] args) throws UnirestException {
		String body = "{\"username\": \"edevries\", \"password\": \"3g2Rw9sT1x\"}";

		HttpResponse<String> response = Unirest.post("https://triptop-identity.wiremockapi.cloud/login")
				.header("Content-type", "application/json")
				.body(body)
				.asString();

		System.out.println(response.getBody());


		JSONObject login = new JSONObject(response.getBody());
		String token = login.getJSONObject("token").getString("value");

		String toegangsControleBody = "{\"username\": \"edevries\", \"application\": \"triptop\"}";

		HttpResponse<String> responseToegangsControle = Unirest.post("https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=" + token)
				.header("Content-type", "application/json")
				.body(toegangsControleBody)
				.asString();

		System.out.println("Toegang en rol: " + responseToegangsControle.getBody());
	}
}



