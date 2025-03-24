package soex.srp.demo;

import java.util.List;

public class Basket {

    private final int id;
    private final List<Product> products;

    public Basket(int id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
