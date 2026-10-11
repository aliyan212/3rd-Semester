public class Student1 {
    String name;
    int rollNumber;
    public Student1(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
    public static void main(String[] args) {
        Student1 student = new Student1("Mateen", 259);
        student.displayInfo();
    }
}
