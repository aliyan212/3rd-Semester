import java.util.Scanner;

public class area {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        System.out.println("Area of the circle: " + area(radius));

        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();
        System.out.println("Area of the rectangle: " + area(length, width));

        System.out.print("Enter the side length of the square: ");
        double side = scanner.nextDouble();
        System.out.println("Area of the square: " + area(side, true));
    }

    public static double area(double radius) {
        return 3.14 * radius * radius;
    }

    public static double area(double length, double width) {
        return length * width;
    }

    public static double area(double side, boolean isSquare) {
        if (isSquare) {
            return side * side;
        }
        return 0; 
    }
}
