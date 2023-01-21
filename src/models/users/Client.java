package models.users;
import java.util.Scanner;

public class Client {
    private int id;
    private String DNI;
    private String name;
    private String lastName;
    private String mechanic;
    private String plate;
    private String maintenance;

    public Client() {
        ++this.id;
    }

    public Client(String DNI, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        ++this.id;
    }

    public Client(String DNI, String name, String lastName, String mechanic, String plate, String maintenance) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        this.mechanic = mechanic;
        this.plate = plate;
        this.maintenance = maintenance;
        ++this.id;
    }

    boolean isValidName(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    // Getters and Setters

    public int getId() {
        return this.id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws Exception {
        if (DNI.length() == 9) {
            this.DNI = DNI;
        } else {
            throw new Exception("DNI must have 9 characters");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {

        if (name.length() <= 2) {
            throw new Exception("Name must have more than 2 characters");
        }

        // valid name, no have numbers
        if (!isValidName(name)) {
            this.name = name;
        } else {
            throw new Exception("Name must have only letters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if (lastName.length() <= 2) {
            throw new Exception("Last name must have more than 2 characters");
        }

        // valid name, no have numbers
        if (!isValidName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new Exception("Last name must have only letters");
        }
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) throws  Exception {

        if(mechanic.length() <= 2) {
            throw new Exception("Mechanic must have more than 2 characters");
        }

        if(!isValidName(mechanic)) {
            throw new Exception("Mechanic must have only letters");
        }else{
            this.mechanic = mechanic;
        }
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) throws Exception {
        if(plate.length() <= 2) {
            throw new Exception("Plate must have more than 2 characters");
        }

        if(!plate.matches("[A-Z]{3}[0-9]{3}")) {
            throw new Exception("Plate must have 3 uppercase letters and 3 numbers");
        }else{
            this.plate = plate;
        }
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) throws Exception {
        if(maintenance.length() <= 8) {
            throw new Exception("Maintenance must have more than 8 characters");
        }
    }

    public void input(Scanner reader) throws Exception {
        boolean isValid = true;
        // why use a do while? because we need
        // to ask for the name at least once
        // ask for name
        // if name is not valid, ask again

        do {

            try {

                System.out.println("Enter the name of the client");
                this.setName(reader.nextLine());

                System.out.println("Enter the last name of the client");
                this.setLastName(reader.nextLine());

                System.out.println("Enter the DNI of the client");
                this.setDNI(reader.nextLine());

                System.out.println("Enter the mechanic of the client");
                this.setMechanic(reader.nextLine());

                System.out.println("Enter the plate of the client");
                this.setPlate(reader.nextLine());

                System.out.println("Enter the maintenance of the client");
                this.setMaintenance(reader.nextLine());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                isValid = false;
            }

        } while (!isValid);
    }

    public void showDetails() {
        System.out.println("Client: " + this.name + " " + this.lastName + " DNI: " + this.DNI);
    }
}
