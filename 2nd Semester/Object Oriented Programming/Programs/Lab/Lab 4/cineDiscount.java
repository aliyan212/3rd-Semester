import java.util.Scanner;
public class cineDiscount {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of people in your group");
        int num=sc.nextInt();
    for(int i=1; i<=num;i++){
                System.out.println("Please enter the age of Person "+i);
                int perAge=sc.nextInt();
                if(perAge>12&&perAge>0){
                    System.out.println("Your ticket would be 200");
                } else if(perAge>12 && perAge<60){
                    System.out.println("Your Ticket would be 200");
                } else if(perAge>=60){
                    System.out.println("Your ticket would be 500");
                } else{
                    System.out.println("You ain't that old. Are you?");
                    i=i-1;
                }
            }
        }
}
