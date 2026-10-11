package Random;
import java.util.Scanner;
public class sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the First Number:");
        int num1 = sc.nextInt();
        System.out.println("Give the Second Number:");
        int num2=sc.nextInt();
        System.out.println("Enter the third number:");
        int num3=sc.nextInt();
        System.out.println(num1 + "x"  + num2 + "x" + num3 + "=" + (num1*num2*num3));
    }
}
