import java.util.Scanner;
public class lessGreat1000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a number");
        int num =sc.nextInt();
        if(num>1000){
            System.out.println("The number is greater then 1000");
        } else if(num==1000){
            System.out.println("The number is equal to 1000");
        } else{
            System.out.println("The number is not greater than 1000");
        }
        if(num*num>1000){
            System.out.println("The square of the number is greater then 1000");
        } else if(num*num==1000){
            System.out.println("The square of the number is equal to 1000");
        }  else{
            System.out.println("The square of the number is not greater than 1000");
        }
    }
}
