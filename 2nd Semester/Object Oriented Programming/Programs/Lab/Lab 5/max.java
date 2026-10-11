import java.util.Scanner;
public class max {
    public static int findMax(int num1, int num2){
        int largest = num1;
        if(num2>largest){
            largest=num2;
        }
        return largest;
    }
    public static float findMax(float num1, float num2){
        float largest = num1;
        if(num2>largest){
            largest=num2;
        }
        return largest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int int1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        int int2 = sc.nextInt();
        System.out.println("The maximum integer is: " + findMax(int1, int2));
        System.out.print("Enter first float: ");
        float float1 = sc.nextFloat();
        System.out.print("Enter second float: ");
        float float2 = sc.nextFloat();
        System.out.println("The maximum float is: " + findMax(float1, float2));
}
}