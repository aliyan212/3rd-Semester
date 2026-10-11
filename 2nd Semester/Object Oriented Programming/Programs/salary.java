import java.util.InputMismatchException;
import java.util.Scanner;

public class salary {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = 0;
        boolean validInput = false;

        // If salary provided as command line argument, use it directly
        if (args.length > 0) {
            try {
                salary = Double.parseDouble(args[0]);
                if (salary < 0) {
                    System.out.println("Salary cannot be negative.");
                    return;
                }
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument. Please provide a numeric salary.");
                sc.close();
                return;
            }
        } else {
            // Interactive input mode
            while (!validInput) {
                System.out.print("Enter your salary: ");
                try {
                    salary = sc.nextDouble();
                    if (salary < 0) {
                        System.out.println("Salary cannot be negative. Please enter a non-negative value.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a numeric value.");
                    sc.next(); // consume invalid token
                }
            }
        }

        double tax = calculateTax(salary);
        double netSalary = salary - tax;

        System.out.printf("Tax: %.2f%n", tax);
        System.out.printf("Total Salary (Net): %.2f%n", netSalary);

        sc.close();
    }

    /**
     * Calculates tax based on progressive tax brackets.
     * 
     * @param salary the gross salary
     * @return the calculated tax amount
     */
    private static double calculateTax(double salary) {
        double tax;
        if (salary <= 250000) {
            tax = 0.0;
        } else if (salary <= 500000) {
            tax = (salary - 250000) * 0.05;
        } else if (salary <= 1000000) {
            tax = 12500 + (salary - 500000) * 0.20;
        } else {
            tax = 112500 + (salary - 1000000) * 0.30;
        }
        return tax;
    }
}