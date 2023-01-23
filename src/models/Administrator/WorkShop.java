package models.Administrator;

import java.util.Scanner;

import models.users.Client;

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
            throw new Exception("Array must have more than 0 elements");
        } else if (arrayClients.length <= 0) {
            throw new Exception("Array must have more than 0 elements");
        } else {
            this.arrayClients = arrayClients;
        }

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) throws Exception {
        if (index < 0) {
            throw new Exception("Index must be greater than 0");
        } else {
            this.index = index;
        }
    }

    // Methods

    public void addClient(Client client, int poss) throws Exception {
        if (client == null) {
            throw new Exception("Client must have more than 0 elements");
        } else if (poss >= this.arrayClients.length) {
            throw new Exception("Array is full");
        } else {
            this.arrayClients[poss] = client;
        }
    }

    public void showClients() {
        for (int i = 0; i < this.index; i++) {
            System.out.println("Client " + (i + 1));
            System.out.println(this.arrayClients[i].toString());
        }
    }

    public void showSearchClientByDni(String dni) {
        for (int i = 0; i < this.index; i++) {
            if (this.arrayClients[i].getDNI().equals(dni)) {
                System.out.println("------------------------------------");
                System.out.println("|             Client " + (i + 1)   + "             |");
                System.out.println("------------------------------------");

                this.arrayClients[i].showData();
            }
        }
    }

    public void showSearchClientPlate(String plate) {

        for (int i = 0; i < this.index; i++) {
            if (this.arrayClients[i].getPlate().equals(plate)) {
                System.out.println("Client: " + (i + 1));
                this.arrayClients[i].showData();
            }
        }
    }

    public void showSearchClientCost(double cost) {
        for (int i = 0; i < this.index; i++) {
            if (this.arrayClients[i].getCost() >= cost) {
                System.out.println("Client: " + (i + 1));
                this.arrayClients[i].showData();
            }
        }
    }

    public void inputClients(Scanner reader) {

        try {
            System.out.print("Ingrese el numero de clientes: ");
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
