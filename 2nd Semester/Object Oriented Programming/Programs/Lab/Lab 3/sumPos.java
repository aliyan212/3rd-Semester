import java.util.Scanner;
public class sumPos {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        int num;
        do{
            System.out.println("Enter the number to sum and enter a negative number to quit:");
            num=sc.nextInt();
        if(num>0){
            sum=sum+num;
        }
        }while(num>0);
        System.out.println("Sum of numbers is: " + sum);
}
}
 