package models.vehiculos;

public class Truck extends Vehicle{
    private int carga;

    public Truck(String plate, String brand, String model, int year, int carga) {
        super(plate, brand, model, year);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getTires() {
        return 8;
    }

}
