package models.vehiculos;

public class Motorcycle extends Vehicle {
    private int cilindraje;

    public Motorcycle(String plate, String brand, String model, int year, int cilindraje) {
        super(plate, brand, model, year);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getTires() {
        return 2;
    }

}
