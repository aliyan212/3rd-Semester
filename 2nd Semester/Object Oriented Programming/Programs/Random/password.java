package Random;
import java.util.Scanner;
public class password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the password:");
        String password = sc.nextLine();
        if(password.equals("Caput Draconis")) {
            System.out.println("Welcome!");
        } else{
            System.out.println("Off with You");
        }
}
}
