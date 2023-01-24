import java.util.Scanner;

import models.Administrator.WorkShop;
import assets.Template;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        WorkShop inspector = new WorkShop();
        Template.presentation();

        int repeat;

        do {

            System.out.println("---------------------------------------------");
            System.out.println("-                   Menu                    -");
            System.out.println("---------------------------------------------");
            System.out.println("|  1. Mostrar integrantes del grupo");
            System.out.println("|  2. Add Clientes");
            System.out.println("|  3. Mostrar  Clientes");
            System.out.println("|  4. Search Clientes por DNI");
            System.out.println("|  5. Search Clientes por Placa de vehiculo");
            System.out.println("|  6. Search Clientes por Costo de mantenimiento");
            System.out.println("|  7. Exit");
            System.out.println("---------------------------------------------");
            System.out.print("Ingrese la opcion: ");
            int option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    System.out.println(Template.ANSI_PURPLE + "         _______");
                    System.out.println("        |.-----.|       Integrantes del grupo ");
                    System.out.println("        ||x . x||      ------------------------");
                    System.out.println("        ||_.-._||      1. Miguel Muniez");
                    System.out.println("        `--)-(--`      2. Ricardo Castro");
                    System.out.println("       __[=== o]__     3. Pablo Pincay Alvarez" + Template.ANSI_RESET);
                    break;

                case 2:
                    inspector.inputClients(reader);
                    break;
                case 3:
                    inspector.showClients();
                    break;
                case 4:
                    System.out.println("Enter the DNI: ");
                    String dni = reader.nextLine();
                    inspector.showSearchClientByDni(dni);
                    break;

                case 5:
                    System.out.println("Enter the plate: ");
                    String plate = reader.nextLine();
                    inspector.showSearchClientPlate(plate);
                    break;

                case 6:
                    System.out.println("Enter the cost: ");
                    double cost = reader.nextDouble();
                    inspector.showSearchClientCost(cost);
                    break;

                case 7:
                    System.out.println("Exit");
                    Template.bye();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

            System.out.println("\nQuiere Continuar?  1. Si 2. No: ");
            repeat = reader.nextInt();

        } while (repeat == 1);

    }
}
