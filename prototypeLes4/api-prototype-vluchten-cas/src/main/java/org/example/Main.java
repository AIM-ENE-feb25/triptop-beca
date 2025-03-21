package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class Main {
    public static void main(String[] args) {
        searchFlight("AMS.AIRPORT", "BCN.AIRPORT", "2025-04-12", "2025-04-19", 1, "0,17", "BEST", "ECONOMY", "EUR");
    }

    private static void searchFlight(String fromId, String toId, String departDate, String returnDate, int adults,
                                     String children, String sort, String cabinClass, String currency) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String apiKey = "bce5053868msh3f7de38b3e4c52bp137140jsn93248ea6b459"; // Replace with your API key

            // Build the request URL
            String url = String.format(
                    "https://booking-com15.p.rapidapi.com/api/v1/flights/searchFlights?" +
                            "fromId=%s&toId=%s&departDate=%s&returnDate=%s&pageNo=1&adults=%d&children=%s&sort=%s&cabinClass=%s&currency_code=%s",
                    fromId, toId, departDate, returnDate, adults, children, sort, cabinClass, currency
            );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("X-RapidAPI-Key", apiKey)
                    .header("X-RapidAPI-Host", "booking-com15.p.rapidapi.com")
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Flight search: " + fromId + " -> " + toId);
            System.out.println("Response status: " + response.statusCode());

            // Convert response body to JSON Object
            JSONObject responseBody = new JSONObject(response.body());

            // Pretty-print the entire JSON response
            System.out.println("Formatted Response:");
            System.out.println(responseBody.toString(2));

            // Extract "data" object
            if (responseBody.has("data")) {
                JSONObject data = responseBody.getJSONObject("data");

                // Extract "flightOffers"
                if (data.has("flightOffers")) {
                    JSONArray flightOffers = data.getJSONArray("flightOffers");
                    if (flightOffers.length() > 0) {
                        for (int i = 0; i < flightOffers.length(); i++) {
                            JSONObject flight = flightOffers.getJSONObject(i);
                            printFlightDetails(flight, i + 1, currency);
                        }
                    } else {
                        System.out.println("No flight offers found.");
                    }
                } else {
                    System.out.println("No 'flightOffers' key found in 'data'.");
                }
            } else {
                System.out.println("No flight data found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printFlightDetails(JSONObject flight, int index, String currency) {
        System.out.println("\nFlight " + index + ":");

        // Ensure flightInfo exists before accessing carrierInfo
        JSONObject flightInfo = flight.optJSONObject("flightInfo");
        JSONObject carrierInfo = (flightInfo != null) ? flightInfo.optJSONObject("carrierInfo") : null;
        JSONArray carriers = (carrierInfo != null) ? carrierInfo.optJSONArray("carriers") : null;

        String airline = (carriers != null && carriers.length() > 0) ? carriers.optString(0, "N/A") : "N/A";

        // Ensure priceBreakdown exists before accessing total
        JSONObject priceBreakdown = flight.optJSONObject("priceBreakdown");
        JSONObject totalPrice = (priceBreakdown != null) ? priceBreakdown.optJSONObject("total") : null;
        String price = (totalPrice != null) ? totalPrice.optInt("units", 0) + " " + currency : "N/A";

        // Ensure segments exist before accessing flight details
        JSONArray segments = flight.optJSONArray("segments");
        if (segments != null && segments.length() > 0) {
            JSONObject firstSegment = segments.optJSONObject(0);
            JSONObject departureAirport = (firstSegment != null) ? firstSegment.optJSONObject("departureAirport") : null;
            JSONObject arrivalAirport = (firstSegment != null) ? firstSegment.optJSONObject("arrivalAirport") : null;

            String departureCity = (departureAirport != null) ? departureAirport.optString("cityName", "Unknown") : "Unknown";
            String arrivalCity = (arrivalAirport != null) ? arrivalAirport.optString("cityName", "Unknown") : "Unknown";
            String departureTime = (firstSegment != null) ? firstSegment.optString("departureTime", "N/A") : "N/A";
            String arrivalTime = (firstSegment != null) ? firstSegment.optString("arrivalTime", "N/A") : "N/A";

            System.out.println("Airline: " + airline);
            System.out.println("Price: " + price);
            System.out.println("Departure: " + departureCity + " at " + departureTime);
            System.out.println("Arrival: " + arrivalCity + " at " + arrivalTime);
        } else {
            System.out.println("No segment details found.");
        }
    }

}
