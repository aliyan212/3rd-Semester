import java.util.Scanner;
public class binToDec {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Binary Number");
        int num=sc.nextInt();
        int decimal=0;
        int power=0;
        while(num>0){
            int digit=num%10;
            decimal+=digit*Math.pow(2,power);
            power++;
            num/=10;
        }
        System.out.println("Decimal Number is "+decimal);
    }
}
