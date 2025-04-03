package han.triptop.backend.domain;


import java.util.List;


public class RestaurantResponse {

    private List<Restaurant> restaurants;
    private boolean cached;

    public RestaurantResponse(List<Restaurant> restaurants, boolean cached) {
        this.restaurants = restaurants;
        this.cached = cached;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    @Override
    public String toString() {
        return "RestaurantResponse{" +
                "restaurants=" + restaurants +
                ", cached=" + cached +
                '}';
    }
}
