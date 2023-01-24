package models.users;

public class Mechanic {
    private String name;
    private String lastName;
    private String speciality;

    public Mechanic(String name, String lastName, String speciality) {
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws  Exception {

        if(name.length() <= 2) {
            throw new Exception("Name must have more than 2 characters");
        }
        // no using numbers or special characters
        if(name.matches("[A-Z][a-z]+")) {
            throw new Exception("Name must start with uppercase and have only letters");
        }else{
            this.name = name;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if(lastName.length() <= 2) {
            throw new Exception("LastName must have more than 2 characters");
        }
        // no using numbers or special characters
        if(!lastName.matches("[A-Z][a-z]+")) {
            throw new Exception("LastName must start with uppercase and have only letters");
        }else{
            this.lastName = lastName;
        }
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) throws Exception {

        String specialities = "Mecanico " + "Electricista " + "Neumatico";

        if(speciality.length() <= 2) {
            throw new Exception("Speciality must have more than 2 characters");
        }

        if(!speciality.matches("[A-Z][a-z]+")) {
            throw new Exception("Speciality must start with uppercase and have only letters");
        }

        if(!specialities.contains(speciality)) {
            throw new Exception("Speciality must be one of the following: Mecanico, Electricista, Neumatico");
        }else{
            this.speciality = speciality;
        }
    }

    public String toString() {
        return "Name: " + this.name + " Last Name: " + this.lastName + " Speciality: " + this.speciality;
    }

}
