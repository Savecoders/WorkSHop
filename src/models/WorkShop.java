package models;
import models.users.Client;
import java.util.Date;
import java.util.Scanner;


public class WorkShop {

    private int idWorkShop;
    Client client = new Client();
    private Date dateOfMaintenance;
    private String description;

    public WorkShop() {
        ++this.idWorkShop;
    }

    public WorkShop(Date dateOfMaintenance, String description) throws Exception {

        this.dateOfMaintenance = dateOfMaintenance;
        this.description = description;
        ++this.idWorkShop;

        Scanner read = new Scanner(System.in);
        this.client.inputInitialData(read);
    }
    public int getIdWorkShop() {
        return this.idWorkShop;
    }

    public void setIdWorkShop(int idWorkShop) {
        this.idWorkShop = idWorkShop;
    }

    public Date getDateOfMaintenance() {
        return this.dateOfMaintenance;
    }

    public void setDateOfMaintenance(Date dateOfMaintenance) throws Exception {

        // valid the date exceptions

        if (dateOfMaintenance == null) {
            throw new Exception("Date of maintenance is required");
        }

        if(dateOfMaintenance.before(new Date())){
            throw new Exception("Date must be after today");
        }

        // the date is later than today
        if(dateOfMaintenance.after(new Date())){
            this.dateOfMaintenance = dateOfMaintenance;
        }

    }

}
