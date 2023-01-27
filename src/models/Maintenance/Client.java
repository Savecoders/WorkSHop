package models.Maintenance;
// class of validations

import assets.Template;
import models.vehiculos.Replacement;
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

    // Vehiculo
    private String plate;
    private String brand;
    private int capacityCar;
    private Date addCarDate;

    // Mantenimiento
    private String maintenance;
    private Date maintenanceDate;
    // Preventivo or Correctivo
    private String typeMaintenance;
    private String[] service;

    private double cost;
    private int totalServices;

    // constants for the services
    private static final String[] TOTAL_SERVICES = {"Lavado", "Alineacion", "Engranaje", "Limpieza", "Reparacion", "Cambio de parabrizas"};

    // replacement

    // arreglo de repuestos
    private Replacement[] replacements;

    // areglo que contenga los nombre
    // precios

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


    // DNI validation
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws Exception {

        if (Validation.lenDNI(DNI)) {
            // valid the character
            if (Validation.isNumeric(DNI)) {
                this.DNI = DNI;

            } else {
                throw new Exception("Please solo Utilice Números. :(");
            }
        } else {
            throw new Exception("DNI debe tener 10 Números");
        }
    }

    // Name validation
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {

        if (name == null) {
            throw new Exception("El nombre no puede ser nulo");
        } else if (Validation.lenName(name)) {
            throw new Exception("El nombre debe tener más de 2 letras");
        }

        // valid name, no have numbers
        if (Validation.isName(name)) {
            this.name = name;
        } else {
            throw new Exception("El nombre debe tener solo letras :(");
        }
    }


    // Last Name validation
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if (name == null) {
            throw new Exception("El nombre no puede ser nulo");
            // valid name, more than 2 characters
        } else if (Validation.lenName(lastName)) {
            throw new Exception("El apellido debe tener más de 2 letras");
        } else {
            // valid name, no have numbers
            if (Validation.isName(lastName)) {
                this.lastName = lastName;
            } else {
                throw new Exception("El apellido debe tener solo letras :(");
            }
        }
    }

    // Mechanic name validation
    public String getMechanic() {
        return mechanic;
    }

    public void setMechanic(String mechanic) throws Exception {

        // valid name, more than 2 characters
        if (name == null) {
            throw new Exception("El nombre no puede ser nulo");
        }
        if (Validation.lenName(mechanic)) {
            throw new Exception("El Mecánico debe tener más de 2 letras");
        } else {
            // valid name, no have numbers
            if (Validation.isName(mechanic)) {
                this.mechanic = mechanic;
            } else {
                throw new Exception("El Nombre del Mecánico debe tener solo letras :(");
            }
        }

    }

    // Plate validation
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) throws Exception {
        // valid plate, 7 characters

        if (plate == null) {
            throw new Exception("La placa no puede ser null");
        } else if (Validation.isLenPlate(plate)) {
            throw new Exception("La placa tiene que tener entre 7 a 8 Números");
        } else {
            // valid plate, 7 numbers
            if (Validation.isNumeric(plate)) {
                this.plate = plate;
            } else {
                throw new Exception("Solo puede tener Números");

            }
        }
    }

    // Brand validation

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws Exception {
        if (brand == null) {
            throw new Exception("La marca no puede ser null");
        } else if (Validation.lenName(brand)) {
            throw new Exception("La marca debe tener más de 2 letras");
        } else {
            // valid name, no have numbers
            if (Validation.isName(brand)) {
                this.brand = brand;
            } else {
                throw new Exception("La marca debe tener solo letras :(");
            }
        }
    }

    public int getCapacityCar() {
        return capacityCar;
    }

    public void setCapacityCar(String capacityCar) throws Exception {
        // valid capacity, 1 number
        if (Validation.isNumeric(capacityCar)) {
            int capacity = Integer.parseInt(capacityCar);
            if (capacity < 1) {
                throw new Exception("La capacidad tiene que ser mayor a 1");
            } else {
                this.capacityCar = capacity;
            }
        } else {
            throw new Exception("Solo puede tener Números");
        }
    }

    public Date getAddCarDate() {
        return addCarDate;
    }

    public void setAddCarDate(Date addCarDate) throws Exception {
        Date today = new Date();

        if (addCarDate == null) {
            throw new Exception("La fecha del coche no puede ser null");
            // la fecha del auto no puede ser mayor a la de hoy
        } else if (addCarDate.getTime() < today.getTime()) {
            this.addCarDate = addCarDate;
        } else {
            throw new Exception("La fecha del auto debe ser anterior a la de hoy");
        }
    }

    public String getTypeMaintenance() {
        return typeMaintenance;
    }

    public void setTypeMaintenance(String typeMaintenance) throws Exception {
        if (typeMaintenance.equalsIgnoreCase("preventivo") || typeMaintenance.equalsIgnoreCase("correctivo")) {
            this.typeMaintenance = typeMaintenance;
        } else {
            throw new Exception("El tipo debe de ser Preventivo o Correctivo no puede ser numeros o caracteres especiales");
        }
    }


    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) throws Exception {
        if (maintenance.length() <= 8) {
            throw new Exception("\n El mantenimiento debe tener más de 8 caracteres");
        } else if (maintenance == null) {
            throw new Exception("El mantenimiento no puede ser nulo");
        }
        this.maintenance = maintenance;
    }

    public Date getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(Date maintenanceDate) throws Exception {

        Date today = new Date();

        if (maintenanceDate == null) {
            throw new Exception("La fecha del coche no puede ser null");
            // la fecha del auto puede ser mayor a la de hoy pero no menor
        } else if (maintenanceDate.getTime() < today.getTime()) {
            throw new Exception("La fecha del mantenimiento debe ser posterior a la de hoy");
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
        if (Validation.isNumeric(totalServices)) {
            if (Integer.parseInt(totalServices) < 0 || Integer.parseInt(totalServices) > 6) {
                throw new Exception("Debe de ser un número entre 1 y 6");
            } else {
                this.totalServices = Integer.parseInt(totalServices);
            }
        } else {
            throw new Exception("El total de servicios debe ser un número");
        }
    }

    public void addNewService(String index, int possition) throws Exception {

        if (index == null) {
            throw new Exception("El index no puede ser nulo");
        }

        if (index.length() == 0) {
            throw new Exception("El index no puede ser vacio");
        }
        // verfica que el index sea un numero
        if (index.equals("1") || index.equals("2") || index.equals("3") || index.equals("4") || index.equals("5") || index.equals("6")) {
            int possIndex = Integer.parseInt(index) - 1;
            // verifica que el servicio no este seleccionado

            for (String service : this.service) {
                if (service!=null && service.equalsIgnoreCase(TOTAL_SERVICES[possIndex])) {
                    throw new Exception("Servicio ya seleccionado por favor seleccione otro :) ");
                }
            }

            // agrega el servicio
            this.service[possition] = TOTAL_SERVICES[possIndex];

        } else {
            throw new Exception("Debe de ser un numero y debe ser entre 1 y 6");
        }

    }

    public void presentServices() {
        // {"Lavado", "Alineacion", "Engranaje", "Limpieza", "Reparacion", "Cambio de parabrizas"};
        System.out.println(Template.ANSI_BLUE + "------------------------------------" + Template.ANSI_RESET);
        System.out.println("\tServicios: ");
        System.out.println(Template.ANSI_BLUE + "------------------------------------" + Template.ANSI_RESET);

        // present the services
        for (int i = 0; i < TOTAL_SERVICES.length; i++) {
            System.out.println("\t" + (i + 1) + ". " + TOTAL_SERVICES[i]);
        }

    }

    public void selectServices(Scanner reader) {
        // ask for the services

        boolean currError, error;
        int selectedServices = 0;

        // present the services
        this.presentServices();

        // ask for the total services
        do {
            currError = false;
            try {
                System.out.println(Template.ANSI_BLUE + "# Segun los servicios mostrados. " + Template.ANSI_RESET);
                System.out.print(Template.ANSI_BLUE + "# Cuantos servicios quisiera adquirir? : " + Template.ANSI_RESET);
                this.setTotalServices(reader.next());
            } catch (Exception e) {
                System.out.println(Template.ANSI_RED + e.getMessage() + Template.ANSI_RESET);
                currError = true;
            }
        } while (this.totalServices > TOTAL_SERVICES.length || this.totalServices < 0 || currError);

        this.service = new String[this.totalServices];

        error = false;
        // ask for the services
        do {
            error = false;

            try {
                System.out.println(Template.ANSI_BLUE + "| Segun los servicios mostrados. " + (selectedServices + 1) + "/" + (this.totalServices) + Template.ANSI_RESET);
                System.out.print(Template.ANSI_CYAN + "Ingrese el numero del servicio que desea agregar: " + Template.ANSI_RESET);
                addNewService(reader.next(), selectedServices);

            } catch (Exception e) {
                error = true;
                System.out.println(Template.ANSI_RED + "* Error: " + e.getMessage() + Template.ANSI_RESET);

            }

            if (!error) {
                selectedServices++;
            }

        } while (error || selectedServices < this.totalServices);
    }

    public double getCost() {
        return cost;
    }

    public void calculateCost() {
        double count = 0;
        // "Lavado", "Alineacion", "Engranaje", "Limpieza", "Reparacion", "Cambio de parabrizas"}
        for (String servi : this.service) {
            switch (servi) {
                case "Lavado":
                    count += 50;
                    break;
                case "Alineacion":
                    count += 60;
                    break;
                case "Engranaje":
                    count += 70;
                    break;
                case "Limpieza":
                    count += 80;
                    break;
                case "Reparacion":
                    count += 90;
                    break;
                case "Cambio de parabrizas":
                    count += 100;
                    break;
            }

        }

        if (this.replacements != null) {
            // add the price of the replacements
            for (Replacement replace : replacements) {
                count += replace.getPrice();
            }
        }

        if (typeMaintenance.equals("Correctivo")) {
            count += 60;
        } else {
            count += 50;
        }

        this.cost = count;
    }

    public void inputInitialData(Scanner reader) throws Exception {
        boolean isValid;
        // if name is not valid, ask again

        do {

            try {
                isValid = true;


                // Template.AnsiColors = color
                System.out.println(Template.ANSI_WHITE + "-----------------------------------------------------------------" + Template.ANSI_RESET);
                System.out.println(Template.ANSI_YELLOW + "|                         Datos del Cliente                     |" + Template.ANSI_RESET);
                System.out.println(Template.ANSI_WHITE + "-----------------------------------------------------------------" + Template.ANSI_RESET);

                System.out.print(Template.ANSI_PURPLE + "| Ingrese el Un Nombre del cliente:  " + Template.ANSI_RESET);
                this.setName(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese el Un Apellido del cliente: " + Template.ANSI_RESET);
                this.setLastName(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese su DNI: " + Template.ANSI_RESET);
                this.setDNI(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese el nombre del mecanico para atenderlo : " + Template.ANSI_RESET);
                this.setMechanic(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese la placa de su vehiculo (7 o 8 números): " + Template.ANSI_RESET);
                this.setPlate(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese la capacidad maxima de pasajeros del vehiculo: " + Template.ANSI_RESET);
                this.setCapacityCar(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese el nombre de la marca del vehiculo: " + Template.ANSI_RESET);
                this.setBrand(reader.next());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese la fecha que adquirió el vehiculo (dd/MM/yyyy): " + Template.ANSI_RESET);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                this.setAddCarDate(formatter.parse(reader.next()));

                // fix the bug
                reader.nextLine();

                System.out.println(Template.ANSI_PURPLE + "| Ingrese la descripcion de sus problemas con el vehiculo: " + Template.ANSI_RESET);
                this.setMaintenance(reader.nextLine());

                System.out.print(Template.ANSI_PURPLE + "| Ingrese la fecha del mantenimiento adquirido (dd/MM/yyyy): " + Template.ANSI_RESET);
                this.setMaintenanceDate(formatter.parse(reader.next()));


                System.out.print(Template.ANSI_PURPLE + "| Ingrese el tipo de mantenimiento (Preventivo o Correctivo): " + Template.ANSI_RESET);
                this.setTypeMaintenance(reader.next());

                if (typeMaintenance.equalsIgnoreCase("Correctivo")) {
                    System.out.print(Template.ANSI_PURPLE + "| Ingrese el numero de respuestos que necesita: " + Template.ANSI_RESET);
                    int length = reader.nextInt();

                    this.replacements = new Replacement[length];

                    System.out.println(Template.ANSI_BLUE + "-----------------------------------------------------------------" + Template.ANSI_RESET);
                    System.out.println(Template.ANSI_BOLD + "|                     Datos de los repuestos                    |" + Template.ANSI_RESET);
                    System.out.println(Template.ANSI_BLUE + "-----------------------------------------------------------------" + Template.ANSI_RESET);

                    for (int i = 0; i < length; i++) {
                        System.out.print(Template.ANSI_CYAN + "| Ingrese el nombre del repuesto " + (i + 1) + "#: " + Template.ANSI_RESET);
                        String name = reader.next();

                        System.out.print(Template.ANSI_CYAN + "| Ingrese el precio del repuesto " + (i + 1) + "#: " + Template.ANSI_RESET);
                        double price = reader.nextDouble();

                        this.replacements[i] = new Replacement(name, price);
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println(Template.ANSI_RED + "!!Ocurrio un error en la conversion, deberia convertir en un numero " + Template.ANSI_RESET);
                isValid = false;
            } catch (ParseException e) {
                System.out.println(Template.ANSI_RED + "\n* Error: " + "EL formato de la fecha ingresada no es: dd/MM/yyyy" + Template.ANSI_RESET);
                isValid = false;
            } catch (Exception e) {
                System.out.println(Template.ANSI_RED + "\n* Error: " + e.getMessage() + "\n" + Template.ANSI_RESET);
                isValid = false;
            }

        } while (!isValid);
        System.out.println(Template.ANSI_GREEN + "---------------------------------------------------------------" + Template.ANSI_RESET);
        System.out.println(Template.ANSI_GREEN + "| Los datos del cliente han sido ingresados correctamente                  |" + Template.ANSI_RESET);
        System.out.println(Template.ANSI_GREEN + "---------------------------------------------------------------" + Template.ANSI_RESET);
        System.out.println();
        System.out.println(Template.ANSI_GREEN + "# Seleccione los servicios que desea adquirir                 |" + Template.ANSI_RESET);
        this.selectServices(reader);
        this.calculateCost();
    }

    public void showData() {

        System.out.println(Template.ANSI_GREEN + "|---------------------------------------------------------------|" + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BOLD + "|                    Los datos del cliente son:                 |" + Template.ANSI_RESET);
        System.out.println(Template.ANSI_GREEN + "|---------------------------------------------------------------|" + Template.ANSI_RESET);


        System.out.println(Template.ANSI_BLUE + "| Nombre: " + this.name + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Apellido: " + this.lastName + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| DNI: " + this.DNI + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Mecanico: " + this.mechanic + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Placa: " + this.plate + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Descripcion del mantenimiento: " + this.maintenance + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Capacidad del Vehiculo: " + this.capacityCar + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| La marca del Vehiculo: " + this.brand + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Tipo mantenimiento: " + this.typeMaintenance + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Adquisicion del Vehiculo: " + this.addCarDate + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Mantenimiento previsto del  Vehiculo: " + this.maintenanceDate + Template.ANSI_RESET);
        System.out.print(Template.ANSI_BLUE + "| Servicios Selecionados: ");

        // for each
        for (String s : this.service) {
            System.out.print(s + " ");
        }
        // separar los servicios
        System.out.println();
        if (this.typeMaintenance.equalsIgnoreCase("Correctivo")) {
            System.out.println(Template.ANSI_BLUE + "| Repuestos: ");
            for (Replacement r : this.replacements) {
                System.out.print(" " + r.getName() + " y cuesta: " + r.getPrice() + "");
            }
            System.out.println(Template.ANSI_RESET);
        }

        System.out.println(Template.ANSI_BLUE + "| Total de servicios: " + this.totalServices + Template.ANSI_RESET);
        System.out.println(Template.ANSI_BLUE + "| Valor a pagar: " + this.cost + Template.ANSI_RESET);
    }

}