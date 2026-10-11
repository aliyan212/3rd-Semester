package Lab;
import java.util.Scanner;
public class result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks:");
        int marks = sc.nextInt();
        char grade;
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }
        System.out.println("The grade is: " + grade);
    }
}
