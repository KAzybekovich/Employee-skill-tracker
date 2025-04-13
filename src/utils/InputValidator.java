package utils;

public class InputValidator {


    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }


    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }


    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-z\\s]{2,}$");
    }
}

