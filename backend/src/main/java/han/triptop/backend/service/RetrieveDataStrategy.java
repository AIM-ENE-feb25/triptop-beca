package han.triptop.backend.service;

public interface RetrieveDataStrategy {

    void retrieveData(int maxRows, String query, String address, int pages);
}
