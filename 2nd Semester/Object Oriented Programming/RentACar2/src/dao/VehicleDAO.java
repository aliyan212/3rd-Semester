package dao;
import model.Vehicle;
import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleDAO {
    
    public void addVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles (model, status, purchase_price, ownership_percentage) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicle.getModel());
            pstmt.setString(2, vehicle.getStatus());
            pstmt.setDouble(3, vehicle.getPurchasePrice());
            pstmt.setDouble(4, vehicle.getOwnershipPercentage());

            pstmt.executeUpdate();
            System.out.println("Vehicle added successfully to the database!");

        } catch (SQLException e) {
            System.out.println("Error adding vehicle.");
            e.printStackTrace();
        }
    }
    public void getAllVehicles() {
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- Fleet Inventory ---");
            boolean hasVehicles = false;

            while (rs.next()) {
                hasVehicles = true;
                int id = rs.getInt("vehicle_id");
                String model = rs.getString("model");
                String status = rs.getString("status");
                double price = rs.getDouble("purchase_price");
                double ownership = rs.getDouble("ownership_percentage");

                System.out.printf("ID: %d | Model: %s | Status: %s | Price: $%.2f | Ownership: %.1f%%\n", 
                                  id, model, status, price, ownership);
            }

            if (!hasVehicles) {
                System.out.println("No vehicles found in the database.");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving vehicles.");
        }
    }
}