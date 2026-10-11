class VehicleParent {
    String type;

    public VehicleParent() {
        this.type = "Unknown";
    }

    public VehicleParent(String type) {
        this.type = type;
    }

    public void displayType() {
        System.out.println("Vehicle Type: " + type);
    }
}
public class CarChild extends VehicleParent {
    String modelName;

    public CarChild() {
        super();
        this.modelName = "Unknown";
    }

    public CarChild(String type, String modelName) {
        super(type);
        this.modelName = modelName;
    }

    public void displayDetails() {
        displayType();
        System.out.println("Car Model: " + modelName);
    }

    public static void main(String[] args) {
        CarChild car1 = new CarChild();
        System.out.println("Car Details:");
        car1.displayDetails();

        CarChild car2 = new CarChild("Sedan", "Toyota Camry");
        System.out.println("\nCar Details:");
        car2.displayDetails();
    }
}