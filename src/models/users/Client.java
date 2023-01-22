package models.users;

import utils.Validation;

import java.util.Scanner;

import java.util.Date;

public class Client {
    // Attributes
    private int id;
    private String DNI;
    private String name;
    private String lastName;
    private String mechanic;
    private String plate;
    private int capacityPerson;
    private Date addCarDate;
    private String maintenance;
    private Date maintenanceDate;

    private String typeMaintenance;

    private String[] service;
    private int totalServices = 0;

    // constants for the services
    private static final String[] TOTAL_SERVICES = {"Lavado", "Alineacion", "Engranaje", "Limpieza", "Reparacion", "Cambio de parabrizas"};


    // Constructors

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

    // Getters and Setters
    public int getId() {
        return this.id;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws Exception {
        if (Validation.lenDNI(DNI)) {
            this.DNI = DNI;
        } else {
            throw new Exception("DNI must have 9 characters");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {

        if (Validation.lenName(name)) {
            throw new Exception("Name must have more than 2 characters");
        }

        // valid name, no have numbers
        if (Validation.isName(name)) {
            this.name = name;
        } else {
            throw new Exception("Name must have only letters");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        // valid name, more than 3 characters
        if (Validation.lenName(lastName)) {
            throw new Exception("Last name must have more than 3 characters");
        } else {
            // valid name, no have numbers
            if (Validation.isName(lastName)) {
                this.lastName = lastName;
            } else {
                throw new Exception("Last name must have only letters");
            }
        }
    }

    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) throws Exception {

        // valid name, more than 3 characters
        if (Validation.lenName(mechanic)) {
            throw new Exception("Mechanic must have more than 3 characters");
        } else {
            // valid name, no have numbers
            if (Validation.isName(mechanic)) {
                throw new Exception("Mechanic must have only letters");
            } else {
                this.mechanic = mechanic;
            }
        }

    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) throws Exception {
        // valid plate, 7 characters
        if (Validation.isPlate(plate)) {
            throw new Exception("Plate must have 7 characters");
        } else {
            // valid plate, 3 uppercase letters and 3 numbers
            if (Validation.isPlateFormat(plate)) {
                throw new Exception("Plate must have 3 uppercase letters and 3 numbers");
            } else {
                this.plate = plate;
            }
        }
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) throws Exception {
        if (maintenance.length() <= 8) {
            throw new Exception("Maintenance must have more than 8 characters");
        }
    }

    // services methods
    public String[] getService() {
        return service;
    }

    public void setService(String[] service) {
        this.service = service;
    }

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(String totalServices) throws Exception {

        if (Validation.isNumberAbs(totalServices)) {
            throw new Exception("Total services must be a number");
        } else {
            this.totalServices = Integer.parseInt(totalServices);
        }

    }

    public void addNewService(String index) throws Exception {

        if (Validation.isNumberAbs(index)) {
            throw new Exception("Index must be a number");
        } else {

            int poss = Integer.parseInt(index) - 1;

            if (poss > TOTAL_SERVICES.length || poss < 0) {
                throw new Exception("Index out of bounds");
            } else if (this.service[poss] != null) {
                throw new Exception("Service already selected please select another one");
            } else {
                this.service[poss] = TOTAL_SERVICES[poss];
            }
        }
    }

    public void presentServices() {
        System.out.println("Services: ");

        for (int i = 0; i < TOTAL_SERVICES.length; i++) {
            System.out.println((i + 1) + ". " + TOTAL_SERVICES[i]);
        }

    }

    public void selectServices(Scanner reader) throws Exception {
        // ask for the services

        boolean currError;
        int selectedServices = 0;

        // present the services
        this.presentServices();

        // ask for the total services
        do {
            currError = false;
            try {
                System.out.println("how many services do you want to add? : ");
                this.setTotalServices(reader.next());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                currError = true;
            }
        } while (this.totalServices > TOTAL_SERVICES.length || this.totalServices < 0 || currError);

        this.service = new String[this.totalServices];

        // ask for the services
        do {
            currError = false;
            try {

                System.out.println("Enter the number of the service");
                addNewService(reader.nextLine());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                currError = true;
            }

            if (!currError) {
                selectedServices++;
            }

        } while (currError && selectedServices < this.totalServices);
    }


    public void inputInitialData(Scanner reader) throws Exception {
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
