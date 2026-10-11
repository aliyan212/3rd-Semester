import java.util.Scanner;
public class Book {
     private String title;
     private double price;
     public void setTitle(String title) {
        this.title = title;
}
public void setPrice(double price) {
    if (price < 0) {
        System.out.println("Warning: Price cannot be negative.");
    } else {
        this.price = price;
    }
}
public String getTitle() {
    return title;
}
public double getPrice() {
    return price;
}
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Book book = new Book();
    System.out.print("Enter the title of the book: ");
    String title = sc.nextLine();
    book.setTitle(title);
    System.out.print("Enter the price of the book: ");
    double price = sc.nextDouble();
    book.setPrice(price);
    System.out.println("Book Title: " + book.getTitle());
    System.out.println("Book Price: " + book.getPrice());
}
}
