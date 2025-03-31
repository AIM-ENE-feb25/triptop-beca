package han.triptop.backend.booking_api;

import org.springframework.stereotype.Service;

@Service
public class ApiV1 implements ApiInterface {

    private boolean upgradeRequired = false;

    @Override
    public String fetchData() {
        if (upgradeRequired) {
            return "Upgrading to API v2...";
        }
        return "Data from API v1";
    }

    public void requestUpgrade() {
        this.upgradeRequired = true;
    }
}
