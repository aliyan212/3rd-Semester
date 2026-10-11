import java.util.Scanner;   
public class convert {
        public static double convert(double celsius) {
        return (celsius * 9/5) + 32;
    }public static double convert(int fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 'C' to convert Celsius to Fahrenheit or 'F' to convert Fahrenheit to Celsius:");
        String choice = sc.nextLine();

        if (choice.equals("C") || choice.equals("c")) {
            System.out.println("Enter temperature in Celsius:");
            double celsius = sc.nextDouble();
            double fahrenheit = convert(celsius);
            System.out.println(celsius + " C is " + fahrenheit + " F");
        } else if (choice == "F" || choice == "f") {
            System.out.println("Enter temperature in Fahrenheit:");
            double fahrenheit = sc.nextDouble();
            double celsius = convert(fahrenheit);
            System.out.println(fahrenheit + " F is " + celsius + " C");
        } else {
            System.out.println("Invalid choice. Please enter 'C' or 'F'.");
        }
    }
}
