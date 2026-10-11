package Lab;
import java.util.Scanner;
public class bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of units consumed:");
        int units = sc.nextInt();
        int bill;
        if (units <= 100) {
            bill = units * 5;
        } else {
            bill = units * 10;
        }
        System.out.println("The electricity bill is: Rs. " + bill);
    }
}
