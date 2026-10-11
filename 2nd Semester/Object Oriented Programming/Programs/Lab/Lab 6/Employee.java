public class Employee {
    /*Define a class Employee with name and jobTitle. 
    Include a method introduce() that prints a sentence like 
    "Hi, I am [name] and I work as a [jobTitle]".
     Create two employee objects in the main method and call their introduction methods. */
    String name;
    String jobTitle;
    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }
    public void introduce() {
        System.out.println("Hi, I am " + name + " and I work as a " + jobTitle);
    }
    public static void main(String[] args) {
        Employee emp1 = new Employee("Mateen", "Software Engineer");
        Employee emp2 = new Employee("Meeran", "Data Analyst");
        emp1.introduce();
        emp2.introduce();
    }
}
