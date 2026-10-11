import java.util.Scanner;
public class Student {
      private String name;
      private int marks;
      public void setName(String name){
        this.name = name; 
      }
      public void setMarks(int marks){
        if(marks >= 0 && marks <= 100){
            this.marks = marks;
        } else {
            System.out.println("Invalid marks. Please enter a value between 0 and 100.");
        }
      }
      public String getGrade(){
        if(marks >= 50){
            return "Pass";
        } else {
            return "Fail";
        }
     }
     public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        student.setName(name);
        
        System.out.print("Enter student's marks: ");
        int marks = scanner.nextInt();
        student.setMarks(marks);
        
        System.out.println("Student Name: " + student.name);
        System.out.println("Student Marks: " + student.marks);
        System.out.println("Grade: " + student.getGrade());
 
 }
}
