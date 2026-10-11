package Lab;
import java.util.Scanner;
public class palindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        if (number < 0) {
            System.out.println("Not a palindrome");
            return;
        }

        long original = number;
        long reverse = 0;
        while (number > 0) {
            long remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }

        if (original == reverse) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

}
