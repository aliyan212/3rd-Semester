import java.util.Scanner;
public class sqrSumDiff {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number:");
        int num2 = sc.nextInt();
        int sq1=num1*num1;
        int sq2=num2*num2;
        int sqrsum = sq1 + sq2;
        int sqrdiff = sq1-sq2;
        System.out.println("The square of first number is:" + sq1);
        System.out.println("The square of second number is:" + sq2);
        System.out.println("The sum of squares is: " + sqrsum);
        System.out.println("The difference of squares is: " + sqrdiff);
    }
}
