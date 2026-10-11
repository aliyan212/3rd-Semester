import java.util.Scanner;
public class Employee {
    int empId;
    String name;
    double salary;

    public Employee() {
        this.empId = 0;
        this.name = "Unknown";
        this.salary = 0.0;
    }

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        Employee E1 = new Employee();
        System.out.println("Employee Details:");
        E1.displayDetails();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();
        Employee E2 = new Employee(empId, name, salary);
        System.out.println("Employee Details:");
        E2.displayDetails();
    }
}
