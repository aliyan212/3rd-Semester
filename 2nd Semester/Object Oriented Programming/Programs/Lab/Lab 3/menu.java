import java.util.Scanner;
public class menu {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("5. Exit");
            choice=sc.nextInt();
        }while(choice!=5);
    }
}
