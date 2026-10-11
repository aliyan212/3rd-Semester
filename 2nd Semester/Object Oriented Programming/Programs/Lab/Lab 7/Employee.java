import java.util.Scanner;
public class Employee {
    int id;
    double salary;
    double performanceScore;
    public Employee(int id, double salary, double performanceScore) {
        this.id = id;
        this.salary = salary;
        this.performanceScore = performanceScore;
    }
    public double calculateBonus() {
        if (performanceScore > 8.0) {
            return salary * 0.10;
        } else {
            return salary * 0.05;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee's ID: ");
        int id = sc.nextInt();
        System.out.print("Enter employee's salary: ");
        double salary = sc.nextDouble();
        System.out.print("Enter employee's performance score: ");
        double performanceScore = sc.nextDouble();
        Employee employee = new Employee(id, salary, performanceScore);
        System.out.println("Bonus for " + employee.id + ": " + employee.calculateBonus());
    }
}
