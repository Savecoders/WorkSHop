import models.Administrator.WorkShop;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Javier1".matches("[A-Z][a-z]+"));
        System.out.println(!"1".matches("[0-9]+"));
        Scanner reader = new Scanner(System.in);
        WorkShop inspector = new WorkShop();
        inspector.inputClients(reader);
        //inspector.showSearchClientByDni("0954190534");
    }
}
