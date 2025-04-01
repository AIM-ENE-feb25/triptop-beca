package han.triptop.backend.adapter;

import com.mashape.unirest.http.JsonNode;

public interface EatsAdapter {

    JsonNode getRestaurantsNearUser(String query, String address);
}
