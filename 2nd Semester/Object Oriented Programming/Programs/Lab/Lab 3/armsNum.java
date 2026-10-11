import java.util.Scanner;
public class armsNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num;
        do{
            System.out.println("Enter a 3 digit number");
            num=sc.nextInt();
        } while(checkNum(num)==0);
        int sum=0;
        for(int i=0;i<=3;i++){
            int rem=num%10;
            sum=sum+(rem*rem*rem);
            num=num/10;
        }
        if(sum==225){
            System.out.println("Armstrong Number");
        }
        else{
            System.out.println("Not an Armstrong Number");
        }
    }
    public static int checkNum(int num){
        if(num>=100 && num<=999){
            return 1;
        }
        else{
            System.out.println("Please enter a 3 digit number.");
            return 0;
        }
    }
}
