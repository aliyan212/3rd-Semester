import java.util.Scanner;
public class numFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int flippedNum = flipNumber(num);
        System.out.println("Flipped number: " + flippedNum);
    }

    public static int flipNumber(int num) {
        int flipped = 0;
        while (num > 0) {
            int digit = num % 10;
            flipped = flipped * 10 + digit;
            num /= 10;
        }
        return flipped;
    }
}