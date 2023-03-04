import java.util.Scanner;
import java.util.regex.Pattern;

public class Day3Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StringBuilder email = new StringBuilder();
        StringBuilder password = new StringBuilder();

        StringBuilder message = new StringBuilder();
        message.append("Hi my name is ,I Welcome you all");

        String name = null;
        String inputEmail;
        String inputPassword;

        System.out.println("Enter your name in \"Name\" format");
        try {

            String inputName = scanner.next();

            if (nameValidation(inputName)) {
                message.insert(14, inputName);
                try {
                    name = message.substring(14, 14 + inputName.length());
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("Start index of message.substring() is greater than length of String");
                }

            } else {
                throw new Exception("Name should start with A-Z and and should contain max 10 char");
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("offset of message.insert() is greater than length of String");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Enter Your email id");
        inputEmail = scanner.next();
        if (emailValidation(inputEmail)) {
            email.append(inputEmail);
        } else {
            try {
                throw new Exception("Enter email in valid format");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("Enter Password it should contain at least 1 uppercase 1 lowercase and 1 special" +
                "character and min 8 characters");
        inputPassword = scanner.next();
        if (passwordValidation(inputPassword)) {
            password.append(inputPassword);
        } else {
            try {
                throw new Exception("Invalid password format");
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        System.out.println(email);
        System.out.println(password);
        System.out.println(message);
        System.out.println("Name = " + name);

        if (name != null) {
            message.delete(14, 14 + name.length());
        }
        System.out.println(message);

        //System.out.println("Enter String to check is it Palindrome");
        StringBuilder inputString = new StringBuilder();
        inputString.append("Dot saw I was Tod");
        //inputString.append(scanner.nextLine());
        if (checkPalindrome(inputString)) {
            System.out.println("It is Palindrome");
        } else {
            System.out.println("It is not Palindrome");
        }

    }

    public static boolean checkPalindrome(StringBuilder originalString) {
        String lowerCaseInput = originalString.toString().toLowerCase();
        String reverse = originalString.reverse().toString().toLowerCase();
        return lowerCaseInput.equals(reverse);
    }

    public static boolean nameValidation(String inputName) {
        Pattern nameValidation = Pattern.compile("^[A-Z][a-z]{2,10}$");
        return nameValidation.matcher(inputName).matches();
    }

    public static boolean emailValidation(String inputEmail) {
        Pattern emailValidation = Pattern.compile("^[a-zA-Z0-9+._-]+@[A-Za-z]+[.][a-z]+$");
        return emailValidation.matcher(inputEmail).matches();
    }

    public static boolean passwordValidation(String inputPassword) {
        Pattern passwordValidation = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}");
        return passwordValidation.matcher(inputPassword).matches();
    }

}
