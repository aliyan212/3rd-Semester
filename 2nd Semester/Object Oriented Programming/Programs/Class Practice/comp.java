import java.util.Scanner;
public class comp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int square=num*num;
        if(square>1000) {
            System.out.println("The square of "+num+" is greater than 100");
        }
        else if (square<1000) {
            System.out.println("The square of "+num+" is less than100");
        } else {
            System.out.println("The square of "+num+" is equal to 100");
        }
    }
}
