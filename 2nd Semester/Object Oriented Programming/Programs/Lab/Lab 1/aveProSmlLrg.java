import java.util.Scanner;
public class aveProSmlLrg {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number");
        int num1=sc.nextInt();
        System.out.println("Enter the second number");
        int num2=sc.nextInt(); 
        int num3=sc.nextInt();
        int sum=num1+num2+num3;
        int average=sum/3;
        int product=num1*num2*num3;
        int smallest=num1;
        if(num2<smallest){
            smallest=num2; 
    }
        if(num3<smallest){
            smallest=num3;
        }
        int largest=num1;
        if(num2>largest){
            largest=num2;
        }
        if(num3>largest){
            largest=num3;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Product: " + product);
        System.out.println("Smallest: " + smallest);
        System.out.println("Largest: " + largest);
    }

}
