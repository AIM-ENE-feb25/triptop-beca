package han.triptop.backend.state;

import com.mashape.unirest.http.exceptions.UnirestException;
import han.triptop.backend.domain.Flight;
import org.springframework.stereotype.Service;

@Service
public class ApiV1 implements ApiState {

    private ApiState nextState;

    @Override
    public Flight getFlights(String from, String to, String date) throws UnirestException {
        setNextState(new ApiV2());
        return nextState.getFlights(from, to, date);
    }

    @Override
    public void setNextState(ApiState nextState) {
        this.nextState = nextState;
    }
}