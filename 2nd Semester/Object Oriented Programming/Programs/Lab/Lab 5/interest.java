import java.util.Scanner;
public class interest {
        public static double calculateInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();
        System.out.print("Enter interest Rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter Time : ");
        double time = sc.nextDouble();

        double interest = calculateInterest(principal, rate, time);
        System.out.println("Simple Interest: " + interest);
    }

}
