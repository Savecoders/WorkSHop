import java.util.Scanner;
import models.Administrator.WorkShop;
import assets.Template;
public class Main {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        WorkShop inspector = new WorkShop();

        do {
            Template.Animation(Template.ANSI_BOLD + "Welcome to the workshop" + Template.ANSI_RESET, 800);
            System.out.println("\n0. Mostrar integrantes del grupo");
            System.out.println("1. Add Clientes");
            System.out.println("2. Mostrar  Clientes");
            System.out.println("3. Search Client by DNI");
            System.out.println("4. Exit");
            System.out.print("Ingrese la opcion: ");
            int option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1 -> inspector.inputClients(reader);
                case 2 -> inspector.showClients();
                case 3 -> {
                    System.out.println("Enter the DNI: ");
                    String dni = reader.nextLine();
                    inspector.showSearchClientByDni(dni);
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        } while (true);

    }
}
