package han.triptop.backend.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class
RestaurantDTO {
    private String query;
    private String address;
}
