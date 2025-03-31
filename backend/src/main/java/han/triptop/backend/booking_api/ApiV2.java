package han.triptop.backend.booking_api;

import org.springframework.stereotype.Service;

@Service
public class ApiV2 implements ApiInterface {

    @Override
    public String fetchData() {
        return "Data from API v2";
    }
}