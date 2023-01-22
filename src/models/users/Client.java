package models.users;
// class of validations

import utils.Validation;
// the resources for the date
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private int capacityCar;
    private Date addCarDate;
    private String maintenance;
    private Date maintenanceDate;

    private String typeMaintenance;

    private String[] service;

    private double cost;
    private int totalServices;

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
            throw new Exception("DNI must have 10 characters");
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
                this.mechanic = mechanic;
            } else {
                throw new Exception("Mechanic must have only letters");
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

    public int getCapacityCar() {
        return capacityCar;
    }

    public void setCapacityCar(String capacityCar) throws Exception {
        if (Validation.isNotNumberAbs(capacityCar)) {
            throw new Exception("Capacity car must be a number");
        } else {
            int capacity = Integer.parseInt(capacityCar);
            if (capacity < 1) {
                throw new Exception("Capacity car must be between 1");
            } else {
                this.capacityCar = capacity;
            }
        }
    }

    public Date getAddCarDate() {
        return addCarDate;
    }

    public void setAddCarDate(Date addCarDate) throws Exception {
        Date today = new Date();

        if (addCarDate == null) {
            throw new Exception("Add car date must be a date");
        } else if (addCarDate.getTime() < today.getTime()) {
            this.addCarDate = addCarDate;
        } else {
            throw new Exception("Car date must be less than today");
        }
    }

    public String getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(String typeMaintenance) throws Exception {
        if (typeMaintenance.equals("Preventivo") || typeMaintenance.equals("Correctivo")) {
            this.typeMaintenance = typeMaintenance;
        } else {
            throw new Exception("Type maintenance must be Preventivo or Correctivo");
        }
    }


    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) throws Exception {
        if (maintenance.length() <= 8) {
            throw new Exception("Maintenance must have more than 8 characters");
        }
        this.maintenance = maintenance;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) throws Exception {

        Date today = new Date();

        if (maintenanceDate == null) {
            throw new Exception("Maintenance date must be a date");
        } else if (maintenanceDate.getTime() < today.getTime()) {
            throw new Exception("Maintenance date must be a future date");
        } else {
            this.maintenanceDate = maintenanceDate;
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

        if (Validation.isNotNumberAbs(totalServices)) {
            throw new Exception("Total services must be a number");
        } else {
            this.totalServices = Integer.parseInt(totalServices);
        }

    }

    public void addNewService(String index) throws Exception {

        if (Validation.isNotNumberAbs(index)) {
            throw new Exception("Index must be a number");
        } else {

            int poss = Integer.parseInt(index) - 1;

            if (this.service[poss] != null) {
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

        boolean currError, error;
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
            error = false;
            try {

                System.out.println("Enter the number of the service");
                addNewService(reader.next());

            } catch (Exception e) {
                System.out.println(e.getMessage());
                error = true;
            }

            if (!error) {
                selectedServices++;
            }

        } while (!error && selectedServices < this.totalServices);
    }

    public double getCost() {
        return cost;
    }

    public void calculateCost() {
        double count = 0;
        // "Lavado", "Alineacion", "Engranaje", "Limpieza", "Reparacion", "Cambio de parabrizas"}
        for (String servi : this.service) {
            switch (servi) {
                case "Lavado" -> count += 10;
                case "Alineacion" -> count += 20;
                case "Engranaje" -> count += 30;
                case "Limpieza" -> count += 40;
                case "Reparacion" -> count += 50;
                case "Cambio de parabrizas" -> count += 60;
            }
        }

        this.cost = this.getTypeMaintenance().equals("Correctivo") ? count + 100 : count;

    }

    public void inputInitialData(Scanner reader) throws Exception {
        boolean isValid;
        // why use a do while? because we need
        // to ask for the name at least once
        // ask for name
        // if name is not valid, ask again

        do {

            try {
                isValid = true;

                System.out.print("Enter the name of the client: ");
                this.setName(reader.next());

                System.out.print("Enter the last name of the client");
                this.setLastName(reader.next());

                System.out.print("Enter the DNI of the client");
                this.setDNI(reader.next());

                System.out.print("Enter the mechanic of the client");
                this.setMechanic(reader.next());

                System.out.print("Enter the plate of the client");
                this.setPlate(reader.next());

                System.out.println("Enter the maintenance of the client");
                this.setMaintenance(reader.next());

                System.out.print("Enter the capacity of the car");
                this.setCapacityCar(reader.next());

                System.out.print("Enter the type of maintenance");
                this.setTypeMaintenance(reader.next());

                System.out.print("Enter the date of the car");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                this.setAddCarDate(formatter.parse(reader.next()));

                System.out.print("Enter the date of the maintenance");
                this.setMaintenanceDate(formatter.parse(reader.next()));

            } catch (NumberFormatException e) {
                System.out.println("The value must be a number");
                isValid = false;
            } catch (ParseException e) {
                System.out.println("The date must be in the format dd/MM/yyyy");
                isValid = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isValid = false;
            }

        } while (!isValid);
        System.out.println("The data was entered correctly");
        System.out.println("The services are: ");
        this.selectServices(reader);
        this.calculateCost();
    }

    public void showData() {
        System.out.println("Name: " + this.name);
        System.out.println("Last name: " + this.lastName);
        System.out.println("DNI: " + this.DNI);
        System.out.println("Mechanic: " + this.mechanic);
        System.out.println("Plate: " + this.plate);
        System.out.println("Maintenance: " + this.maintenance);
        System.out.println("Capacity car: " + this.capacityCar);
        System.out.println("Type maintenance: " + this.typeMaintenance);
        System.out.println("Add car date: " + this.addCarDate);
        System.out.println("Maintenance date: " + this.maintenanceDate);
        System.out.println("The services are: ");
        for (String s : this.service) {
            System.out.println(s);
        }
        System.out.println("Total services: " + this.totalServices);
        System.out.println("Cost: " + this.cost);
    }

}
