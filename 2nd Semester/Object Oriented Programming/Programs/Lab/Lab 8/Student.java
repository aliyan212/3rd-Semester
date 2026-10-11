public class Student {
    String name;
    int rollNo;
    float marks;

    Student() {
        this.name = "Unknown";
        this.rollNo = 0;
        this.marks = 0.0f;
    }

    Student(String name, int rollNo, float marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("Student 1 Details:");
        student1.displayDetails();
        Student student2 = new Student("Meeran", 191, 85.5f);
        System.out.println("Student 2 Details:");
        student2.displayDetails();
    }
}