import java.util.Scanner;;
public class monitor {
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    for(int i=1;i<=4;i++){
        System.out.println("Enter the temprature for Hour " + 1);
        int temp=sc.nextInt();
        if(temp>80){
            System.out.println("Critical");
        } else if(temp>50 && temp<=80){
            System.out.println("Normal");
        } else {
            System.out.println("Idle");
        }
    }
}
}
