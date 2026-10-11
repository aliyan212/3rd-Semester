import java.util.Scanner;
public class hello {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int square=num*num;
        System.out.println("The square of "+num+" is "+square);
    }
}