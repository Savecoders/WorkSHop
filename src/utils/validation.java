package utils;

public class validation {
    public static boolean isName(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    public static boolean isLastName(String lastName) {
        return lastName.length() > 2;
    }

    public static boolean isDNI(String DNI) {
        return DNI.length() == 9;
    }

    public static boolean isSpeciality(String speciality) {
        String specialities = "mecanico electricista neumatico";
        return specialities.toLowerCase().contains(speciality);
    }

    public static boolean isPlate(String plate) {
        return plate.length() == 7;
    }

}
