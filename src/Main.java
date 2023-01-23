import java.util.Scanner;
import models.Administrator.WorkShop;
public class Main {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        WorkShop inspector = new WorkShop();
        inspector.inputClients(reader);
        inspector.showSearchClientByDni("0954190534");

    }
}
