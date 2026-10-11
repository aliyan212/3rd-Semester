public class Rectangle {
    double length;
    double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    public double calculateArea() {
        return length * width;
    }
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5.0, 3.0);
        System.out.println("Area of the rectangle: " + r.calculateArea());
    }
}
