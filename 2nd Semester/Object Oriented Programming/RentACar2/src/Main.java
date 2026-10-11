import dao.VehicleDAO;
import dao.UserDAO;
import model.User;
import model.Vehicle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleDAO vehicleDAO = new VehicleDAO();
        UserDAO userDAO = new UserDAO();

        while (true) {
            System.out.println("\n=== RENT-A-CAR SYSTEM ===");
            System.out.println("1. Add a New Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Add a New User");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Car Model (e.g., Honda Civic 2022): ");
                String model = scanner.nextLine();
                
                System.out.print("Enter Status (e.g., AVAILABLE, RENTED): ");
                String status = scanner.nextLine();
                
                System.out.print("Enter Purchase Price: ");
                double price = scanner.nextDouble();
                
                System.out.print("Enter Ownership Percentage (e.g., 100 or 50.5): ");
                double ownership = scanner.nextDouble();

                // Create the object and push it to MariaDB
                Vehicle newCar = new Vehicle(model, status, price, ownership);
                vehicleDAO.addVehicle(newCar);

            } else if (choice == 2) { 
                vehicleDAO.getAllVehicles();
            } else if (choice == 3) {
                System.out.print("Enter CNIC: ");
                String cnic = scanner.nextLine();

                System.out.print("Enter Role: ");
                String role = scanner.nextLine();

                System.out.print("Enter License Number: ");
                String licenseNo = scanner.nextLine();

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Address: ");
                String address = scanner.nextLine();

                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();

                User newUser = new User(cnic, role, licenseNo, name, address, phoneNumber);
                userDAO.addUser(newUser);
            } else if (choice == 4) {
                System.out.println("Shutting down...");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
