import java.util.Scanner;
public class cps {
      public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num1=sc.nextInt();
            int num2=sc.nextInt();
            int num3=sc.nextInt();
            float average=(num1+num2+num3)/3;
            int product=num1*num2*num3;
            int sum=num1+num2+num3;
            System.out.println("Sum: "+sum);
            System.out.println("Average: "+average);
            System.out.println("Product: "+product);
            int smallest = num1;
            if(num2 < smallest) {
                smallest = num2;
            }
             if(num3 < smallest) {
                smallest = num3;
}
            System.out.println("Smallest: "+smallest);  
            int largest = num1;
            if(num2 > largest) {
                largest = num2;
            }
            if(num3 > largest) {
                largest = num3;
}
            System.out.println("Largest: "+largest);
        }    
}
}
