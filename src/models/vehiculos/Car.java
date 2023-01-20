package models.vehiculos;

public class Car extends Vehicle {
    private int doors;
    private int passengers;

    public Car(String plate, String brand, String model, int year, int doors, int passengers) {
        super(plate, brand, model, year);
        this.doors = doors;
        this.passengers = passengers;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getTires() {
        return 4;
    }

}

