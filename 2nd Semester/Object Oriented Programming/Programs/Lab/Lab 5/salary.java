import java.util.Scanner;
public class salary {
public static int calculateSalary(int baseSalary, int bonus) {
    return baseSalary + bonus;
}
public static double calculateSalary(double hoursWorked, double hourlyRate) {
    return hoursWorked * hourlyRate;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter base salary:");
    int baseSalary = sc.nextInt();
    System.out.println("Enter bonus:");
    int bonus = sc.nextInt();
    int totalSalary = calculateSalary(baseSalary, bonus);
    System.out.println("Total Salary : " + totalSalary);
    System.out.println("Enter hours worked:");
    double hoursWorked = sc.nextDouble();
    System.out.println("Enter hourly rate:");
    double hourlyRate = sc.nextDouble();
    double totalHourlySalary = calculateSalary(hoursWorked, hourlyRate);
    System.out.println("Total Salary : " + totalHourlySalary);

}
}
