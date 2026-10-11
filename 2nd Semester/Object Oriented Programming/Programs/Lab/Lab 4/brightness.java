import java.util.Scanner;
public class brightness {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<5; i++){
            System.out.println("Enter the brightness for Room :"  + i);
            int bright=sc.nextInt();
            if(bright>70 && bright<=100){
                System.out.println("Lights Off");
            } else if(bright>30 && bright<=70){
                System.out.println("Dim Lights");
            } else if(bright>0 && bright<=30){
                System.out.println("Lights On");
            } else {
                System.out.println("Pleasse enter the correct value");
                i=i-1;
            }
        }
    }
}
