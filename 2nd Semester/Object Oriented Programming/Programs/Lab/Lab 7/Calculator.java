import java.util.Scanner;
public class Calculator {
    int num1;
    int num2;
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    public void add() {
        System.out.println("Sum: " + (num1 + num2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        Calculator c = new Calculator(num1, num2);
        c.add();
    }
}
