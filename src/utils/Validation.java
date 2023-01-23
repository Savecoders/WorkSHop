package utils;

public class Validation {
    public static boolean isName(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    public static boolean lenName(String lastName) {
        return lastName.length() < 2;
    }

    public static boolean lenDNI(String DNI) {
        return DNI.length() == 10;
    }

    public static boolean isSpeciality(String speciality) {
        String specialities = "mecanico electricista neumatico";
        return specialities.toLowerCase().contains(speciality);
    }

    public static boolean isPlate(String plate) {
        return !(plate.length() == 7);
    }

    public static boolean isPlateFormat(String plate) {
        return plate.matches("[A-Z]{3}[0-9]{3}");
    }

    public static boolean isDNI(String DNI) {
        return DNI.matches("[0-9]{10}");
    }

    public static boolean isNotNumberAbs(String number) {
        return !number.matches("[0-9]+");
    }

}
