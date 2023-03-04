import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        //Scanner scanner= new Scanner(System.in);
        //System.out.println("Enter String to check is it Palindrome");
        StringBuilder inputString = new StringBuilder();
        inputString.append("Dot saw I was Tod");
        //inputString.append(scanner.nextLine());
        if (checkPalindrome(inputString)) {
            System.out.println("It is Palindrome");
        } else {
            System.out.println("It is not Palindrome");
        }
//        scanner.close();
    }

    public static boolean checkPalindrome(StringBuilder originalString) {
        String lowerCaseInput = originalString.toString().toLowerCase();
        String reverse = originalString.reverse().toString().toLowerCase();
        return lowerCaseInput.equals(reverse);
    }
}
