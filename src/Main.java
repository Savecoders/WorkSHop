import java.util.Scanner;

import models.Administrator.WorkShop;
import assets.Template;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // clase taller
        WorkShop inspector = new WorkShop();
        Template.presentation();

        String repeat;

        do {

            Template.menu();
            System.out.print("Ingrese la opcion: ");
            String option = reader.next();

            switch (option) {
                case "1":
                    System.out.println(Template.ANSI_PURPLE + "         _______");
                    System.out.println("        |.-----.|       Integrantes del grupo ");
                    System.out.println("        ||x . x||      ------------------------");
                    System.out.println("        ||_.-._||      1. Miguel Muniez");
                    System.out.println("        `--)-(--`      2. Ricardo Castro");
                    System.out.println("       __[=== o]__     3. Pablo Pincay Alvarez" + Template.ANSI_RESET);
                    break;

                case "2":
                    inspector.inputClients(reader);
                    break;
                case "3":
                    inspector.showClients();
                    break;
                case "4":
                    System.out.print("Ingrese la DNI: ");
                    String dni = reader.next();
                    try {
                        inspector.showSearchClientByDni(dni);
                    } catch (Exception e) {
                        System.out.println(Template.ANSI_RED + e.getMessage() + Template.ANSI_RESET);
                    }
                    break;

                case "5":
                    System.out.print("Ingrese la placa del vehiculo del usuario: ");
                    String plate = reader.next();
                    try {
                        inspector.showSearchClientPlate(plate);
                    } catch (Exception e) {
                        System.out.println(Template.ANSI_RED + e.getMessage() + Template.ANSI_RESET);
                    }
                    break;

                case "6":
                    System.out.print("Ingrese la marca a buscar: ");
                    String brand = reader.next();
                    try {
                        inspector.showSearchClientByBrand(brand);
                    } catch (Exception e) {
                        System.out.println(Template.ANSI_RED + e.getMessage() + Template.ANSI_RESET);
                    }
                    break;

                case "7":
                    System.out.print("Enter the cost: ");
                    String cost = reader.next();
                    try {
                        inspector.showSearchClientCost(cost);
                    } catch (Exception e) {
                        System.out.println(Template.ANSI_RED + e.getMessage() + Template.ANSI_RESET);
                    }
                    break;

                case "8":
                    System.out.println("Exit");
                    Template.bye();
                    break;

                default:
                    System.out.println(Template.ANSI_RED + "Opcion no valida asegurese de ingresar un numero del 1 al 8" + Template.ANSI_RESET);
                    break;
            }

            boolean haveERROR;

            do {
                System.out.print("\nPara continuar y ver el menu digite 1 para Si 2 para No: ");
                repeat = reader.next();

                if (!repeat.equalsIgnoreCase("2") && !repeat.equalsIgnoreCase("1")) {
                    System.out.println(Template.ANSI_RED + "Opcion no valida asegurese de ingresar un numero del 1 al 2" + Template.ANSI_RESET);
                    haveERROR = true;
                } else {
                    haveERROR = false;
                }
            } while (haveERROR);

        } while (repeat.equalsIgnoreCase("1"));

    }
}
