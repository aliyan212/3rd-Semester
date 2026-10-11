import java.util.Scanner;
public class fibbo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms in fibonacci series");
        int num = sc.nextInt();
        int a = 0, b = 1, c;
        System.out.print("Fibonacci series: ");
        for(int i = 1; i <= num; i++){
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c; 
        }
    }
}
