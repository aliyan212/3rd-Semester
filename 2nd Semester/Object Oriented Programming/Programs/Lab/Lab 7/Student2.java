import java.util.Scanner;
public class Student2 {
    String name;
    int marks;
    public Student2(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public void displayGrade() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 80) {
            System.out.println("Grade: B");
        } else if (marks >= 70) {
            System.out.println("Grade: C");
        } else if (marks >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's name: ");
        String name = sc.nextLine();
        System.out.print("Enter student's marks: ");
        int marks = sc.nextInt();
        Student2 student = new Student2(name, marks);
        student.displayGrade();
    }
}
