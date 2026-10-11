import java.util.Scanner;
public class result {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter the marks of Student " + i);
            int marks = sc.nextInt();
            if(marks>=50){
                System.out.println("Student " + i + " has passed.");
            } else {
                System.out.println("Student " + i + " has failed.");
            }
        }
    }
}
