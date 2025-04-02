package han.triptop.backend.adapter;

import org.json.JSONObject;

public interface EatsAdapter {

    JSONObject getRestaurantsNearUser(String query, String address);
}
