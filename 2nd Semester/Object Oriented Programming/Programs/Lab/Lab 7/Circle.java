import java.util.Scanner;
public class Circle {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return 3.14 * radius * radius;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);
        double area = circle.calculateArea();
        System.out.println("Area of the circle: " + area);
    }
}
