package models.users;

import java.util.Scanner;

public class Client {
    private int id;
    private String DNI;
    private String name;
    private String lastName;

    // Constructor void

    public Client() {
        ++this.id;
    }

    public Client(String DNI, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.DNI = DNI;
        ++this.id;
    }

    // funtionals

    boolean isValidName(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must have only letters");
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
        if (isValidName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name must have only letters");
        }
    }

    public void input(Scanner keybScanner) throws Exception {
        boolean isValid = false;
        // why use a do while? because we need to ask for the name at least once

        // ask for name
        // if name is not valid, ask again
        do {
            try {
                System.out.println("Enter the name of the client");
                this.setName(keybScanner.nextLine());
                isValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);

        isValid = false;

        do {
            try {
                System.out.println("Enter the last name of the client");
                this.setLastName(keybScanner.nextLine());
                isValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);

        isValid = false;

        do {
            try {
                System.out.println("Enter the DNI of the client");
                this.setDNI(keybScanner.nextLine());
                isValid = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!isValid);

    }
    public void showDetails() {
        System.out.println("Client: " + this.name + " " + this.lastName + " DNI: " + this.DNI);
    }
}
