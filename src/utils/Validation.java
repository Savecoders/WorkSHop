package utils;

public class Validation {
    public static boolean isName(String name) {
        String container = "0123456789!@#$%^&*()_+{}|:<>?[];',./";
        return !name.contains(container);
    }

    public static boolean lenName(String lastName) {
        return lastName.length() < 2;
    }

    public static boolean lenDNI(String DNI) {
        return DNI.length() == 10;
    }

    public static boolean isPlate(String plate) {
        return !(plate.length() == 7);
    }

    public static boolean isPlateFormat(String plate) {
        // the general method is: [A-Z]{3}[0-9]{3}
        String container = "@#$%^&*()_+{}|:<>?[];',./";
        //return plate.matches("[A-Z]{3}[0-9]{3}") && !plate.contains(container);
        return plate.matches("[0-9]{7}") && !plate.contains(container);
    }

    public static boolean isDNI(String DNI) {
        String container = "@#$%^&*()_+{}|:<>?[];',./";
        return DNI.matches("[0-9]{10}") && !DNI.contains(container);
    }

    public static boolean isNotNumberAbs(String number) {
        String container = "@#$%^&*()_+{}|:<>?[];',./";
        return !number.matches("[0-9]+") && !number.contains(container);
    }
      public static void isNumerical(String[] args) {
        String str = "1123";
        try {
        Double.parseDouble(str);
        System.out.println("It is numerical string");
        }catch(NumberFormatException e) {
            System.out.println("It is not numerical string");
        }
    }

}
