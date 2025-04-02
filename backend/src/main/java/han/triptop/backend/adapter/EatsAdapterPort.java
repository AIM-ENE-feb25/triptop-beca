package han.triptop.backend.adapter;

import org.json.JSONObject;

public interface EatsAdapterPort {

    JSONObject getRestaurantsNearUser(String query, String address);
}
