package org.example;

import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        testApi("ljansen", "4fR9dG1h7w");
        testApi("svisser", "7iK3jM5n8b");
        testApi("tbos", "8vC3xQ6w9e");
    }

    private static void testApi(String username, String password) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String json = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);

            // First request to get the token
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://triptop-identity.wiremockapi.cloud/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Request for user: " + username);
            System.out.println("Response status: " + response.statusCode());
            System.out.println("Response body: " + response.body());

            JSONObject responseBody = new JSONObject(response.body());
            String token = responseBody.getJSONObject("token").getString("value");

            checkAppAccess(client, token, username, "triptop");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkAppAccess(HttpClient client, String token, String username, String application) {
        try {
            String json = String.format("{\"username\": \"%s\", \"application\": \"%s\"}", username, application);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=" + token))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json, StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Request for app access check:");
            System.out.println("Response status: " + response.statusCode());
            System.out.println("Response body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
