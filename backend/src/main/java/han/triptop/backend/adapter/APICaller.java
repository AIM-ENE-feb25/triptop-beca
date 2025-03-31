package han.triptop.backend.adapter;


public abstract class APICaller {

    protected String token;

    public String executeAPICall() {
        if (token.isEmpty()) {
            login();
        }
        return callAPI();
    }

    public abstract void login();

    public abstract void checkToken();
    // wat doet checkToken in dit prototype? toevoegen aan if-statement?

    public abstract String callAPI();
}
