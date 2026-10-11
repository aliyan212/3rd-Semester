import java.util.Scanner;
public class Student {
    String name;
    double marks;
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
    public String calculateGrade() {
        if (marks >= 90) {
            return "A";
        } else if (marks >= 75) {
            return "B";
        } else {
            return "C";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String name = sc.nextLine();
        System.out.print("Enter student's marks: ");
        double marks = sc.nextDouble();
        Student student = new Student(name, marks);
        System.out.println("Grade for " + student.name + ": " + student.calculateGrade());
    }
}
