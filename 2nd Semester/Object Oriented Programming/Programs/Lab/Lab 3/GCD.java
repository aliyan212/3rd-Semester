import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int gcd = findGCD(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }

    public static int findGCD(int a, int b) {
        int largest= a;
        if(b>largest){
            largest=b;
        }
        int GCD=1;
        for(int i=1;i<=largest;i++){
            if(a%i==0 && b%i==0){
                GCD=i;
            }
        }
        return GCD;
    }
}
