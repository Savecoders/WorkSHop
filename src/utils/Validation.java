package utils;

public class Validation {
    public static boolean isName(String name) {
        // validate if the string no contains numbers
        // using for loop

        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean lenName(String lastName) {
        return lastName.length() <= 2;
    }

    public static boolean lenDNI(String DNI) {
        return DNI.length() == 10;
    }

    public static boolean isLenPlate(String plate) {
        return !(plate.length() >= 7 && plate.length() <= 8);
    }

    public static boolean isStrNumber(String plate) {

        // validate if the string no contains letters and symbols
        // using for loop

        for (int i = 0; i < plate.length(); i++) {
            if (Character.isLetter(plate.charAt(i))) {
                return false;
            }
        }

        return true;

    }

}
