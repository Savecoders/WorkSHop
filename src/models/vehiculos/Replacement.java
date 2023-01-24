package models.vehiculos;

public class Replacement {
    private String name;
    private double price;

    public Replacement(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price <= 0) {
            throw new Exception("El precio no puede ser menor o igual a 0");
        } else {
            this.price = price;
        }
    }
}
