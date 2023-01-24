package models.Administrator;

import java.util.Scanner;

import models.Maintenance.Client;

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
        for (int i = 0; i < this.index; i++) {
            System.out.println("------------------------------------");
            System.out.println("|             Cliente  #" + (i + 1)   + "             |");
            System.out.println("------------------------------------");
            this.arrayClients[i].showData();
        }
    }

    public void showSearchClientByDni(String dni) {
        for (int i = 0; i < this.index; i++) {
            if (this.arrayClients[i].getDNI().equals(dni)) {
                System.out.println("------------------------------------");
                System.out.println("|             Cliente  #" + (i + 1) + "             |");
                System.out.println("------------------------------------");

                this.arrayClients[i].showData();
            }
        }
    }

    public void showSearchClientPlate(String plate) {

        for (int i = 0; i < this.index; i++) {
            if (this.arrayClients[i].getPlate().equals(plate)) {
                System.out.println("------------------------------------");
                System.out.println("|             Cliente  #" + (i + 1) + "             |");
                System.out.println("------------------------------------");
                this.arrayClients[i].showData();
            }
        }
    }

    public void showSearchClientCost(double cost) {
        for (int i = 0; i < this.index; i++) {
            if (this.arrayClients[i].getCost() >= cost) {
                System.out.println("------------------------------------");
                System.out.println("|             Cliente  #" + (i + 1) + "             |");
                System.out.println("------------------------------------");
                this.arrayClients[i].showData();
            }
        }
    }

    public void inputClients(Scanner reader) {

        try {
            System.out.print("Ingrese el numero de clientes que desea: ");
            this.setIndex(reader.nextInt());
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
