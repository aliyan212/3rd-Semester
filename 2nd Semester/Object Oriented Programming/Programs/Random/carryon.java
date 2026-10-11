package Random;
import java.util.Scanner;
public class carryon {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    while (true) {
       if(s.equals("carry on")) {
           System.out.println("carry on");
           s = sc.nextLine();
       } else {
           break;
       }
    }
}
}
