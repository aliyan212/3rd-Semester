public class Car {
    String model;
    int year;
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }
    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
    public static void main(String[] args) {
        Car car1 = new Car("Ford Mustang", 2020);
        Car car2 = new Car("Toyota Altis", 2021);
        car1.displayDetails();
        car2.displayDetails();
    }
}
