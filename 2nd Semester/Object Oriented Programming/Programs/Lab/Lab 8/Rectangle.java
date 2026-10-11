public class Rectangle {
    double length;
    double width;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle R1 = new Rectangle();
        System.out.println("Area of rectangle: " + R1.area());
        Rectangle R2 = new Rectangle(6, 7);
        System.out.println("Area of rectangle: " + R2.area());
    }
}
