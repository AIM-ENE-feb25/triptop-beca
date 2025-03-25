class Order {
private User user;

    public void printOrderDetails() {
        System.out.println(user.getShippingDetails().getDeliveryDate()); 
    }
}

class User {
private Address address;

    public ShippingDetails getShippingDetails() {
        return address.getShippingDetails(); 
    }
}

class Address {
private ShippingDetails shippingDetails;

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }
}

class ShippingDetails {
private String deliveryDate;

    public String getDeliveryDate() {
        return deliveryDate;
    }
}
