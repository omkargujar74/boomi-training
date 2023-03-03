import java.util.Scanner;
import java.util.regex.Pattern;

public class Day3Program {
    public static void main(String[] args) {

        Pattern nameValidation = Pattern.compile("^[A-Z]{1}[a-z]{0,9}$");
        Pattern emailValidation = Pattern.compile("^[A-za-z0-9._]+@[A-Za-z.]*$");

        Scanner scanner = new Scanner(System.in);

        StringBuilder email = new StringBuilder();

        StringBuilder message = new StringBuilder();
        message.append("Hi my name is ,I Welcome you all");

        String name = null;
        String inputEmail;

        System.out.println("Enter your name in \"Name\" format");
        try {

            String inputName = scanner.next();

            if (nameValidation.matcher(inputName).matches()) {
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
        if (emailValidation.matcher(inputEmail).matches()) {
            email.append(inputEmail);
        } else {
            try {
                throw new Exception("Enter email in valid format");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(email);
        System.out.println(message);
        System.out.println("Name = " + name);

        message.delete(14, 14 + name.length());
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

}
