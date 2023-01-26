package models.Administrator;

import java.util.Scanner;

import models.Maintenance.Client;

import utils.Validation;

public class WorkShop {
    private Client[] arrayClients;
    private int index;

    // Constructor
    public WorkShop() {
        this.arrayClients = new Client[3];
    }

    // Getters and Setters

    public Client[] getArrayClients() {
        return arrayClients;
    }

    public void setArrayClients(Client[] arrayClients) throws Exception {
        if (arrayClients == null) {
            throw new Exception("El arreglo de clientes no puede ser nulo");
        } else if (arrayClients.length == 0) {
            throw new Exception("El arreglo de clientes no puede ser vacio");
        } else {
            this.arrayClients = arrayClients;
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) throws Exception {
        if (index < 0) {
            throw new Exception("Indice no puede ser negativo");
        } else {
            this.index = index;
        }
    }

    // Methods

    public void addClient(Client client, int poss) throws Exception {
        if (client == null) {
            throw new Exception("El Objecto cliente no puede ser nulo");
        } else if (poss >= this.arrayClients.length) {
            throw new Exception("El Array de clientes esta lleno :(");
        } else {
            this.arrayClients[poss] = client;
        }
    }

    public void showClients() {

        if (this.index == 0) {
            System.out.println("No hay clientes registrados");
        }


        try {
            for (int i = 0; i < this.index; i++) {
                System.out.println("--------------------------------------");
                System.out.println("|              Cliente  #" + (i + 1) + "             |");
                System.out.println("--------------------------------------");
                this.arrayClients[i].showData();
            }
        } catch (Exception e) {
            System.out.println("No hay clientes registrados");
        }
    }

    public void showSearchClientByDni(String dni) throws Exception {

        boolean include = false;

        if (this.index == 0) {
            System.out.println("No hay clientes registrados");
        } else if (dni == null) {
            throw new Exception("El dni no puede ser nulo");
        } else if (!Validation.isNumeric(dni)) {
            throw new Exception("La Placa solo debe de tener numeros");
        } else {

            try {
                for (int i = 0; i < this.index; i++) {
                    if (this.arrayClients[i].getDNI().equalsIgnoreCase(dni)) {
                        System.out.println("--------------------------------------");
                        System.out.println("|              Cliente  #" + (i + 1) + "             |");
                        System.out.println("--------------------------------------");

                        this.arrayClients[i].showData();
                        include = true;
                    }
                }

                if (!include) {
                    throw new Exception("No se encontro el cliente");
                }

            } catch (Exception e) {
                System.out.println("No se encontro el cliente");
            }
        }
    }

    public void showSearchClientPlate(String plate) throws Exception {

        boolean include = false;


        if (this.index == 0) {
            throw new Exception("No hay clientes registrados");
        } else if (plate == null) {
            throw new Exception("El costo no puede ser nulo");
        } else if (!Validation.isNumeric(plate)) {
            throw new Exception("La Placa solo debe de tener numeros");
        } else {
            try {

                for (int i = 0; i < this.index; i++) {
                    if (this.arrayClients[i].getPlate().equals(plate)) {
                        System.out.println("------------------------------------");
                        System.out.println("|             Cliente  #" + (i + 1) + "             |");
                        System.out.println("------------------------------------");
                        this.arrayClients[i].showData();
                        include = true;
                    }
                }

                if (!include) {
                    throw new Exception("No se encontro el cliente");
                }

            } catch (Exception e) {
                System.out.println("No se encontro el cliente");
            }
        }

    }

    public void showSearchClientCost(String cost) throws Exception {

        boolean include = false;

        if (this.index == 0) {
            throw new Exception("No hay clientes registrados");
        } else if (cost == null) {
            throw new Exception("El costo no puede ser nulo");
        } else if (!Validation.isNumeric(cost)) {
            throw new Exception("El costo debe ser numerico");
        } else if (Double.parseDouble(cost) < 0) {
            throw new Exception("El costo no puede ser negativo");
        } else {
            try {

                double costValue = Double.parseDouble(cost);

                for (int i = 0; i < this.index; i++) {

                    if (this.arrayClients[i].getCost() >= costValue) {
                        System.out.println("-------------------------------------");
                        System.out.println("|             Cliente  #" + (i + 1) + "             |");
                        System.out.println("-------------------------------------");
                        this.arrayClients[i].showData();
                        include = true;
                    }
                }

                if (!include) {
                    throw new Exception("No hay clientes con ese costo");
                }

            } catch (Exception e) {
                System.out.println("No se encontro el cliente");
            }
        }
    }

    public void inputClients(Scanner reader) {

        try {
            System.out.println("--------------------------------------------------");
            System.out.print("Ingrese el numero de clientes que desea: ");
            this.setIndex(reader.nextInt());
            System.out.println("--------------------------------------------------");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        this.arrayClients = new Client[this.index];

        try {

            for (int i = 0; i < this.index; i++) {
                Client client = new Client();
                client.inputInitialData(reader);
                this.addClient(client, i);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
