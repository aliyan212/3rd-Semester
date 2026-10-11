package dao;

import model.User;
import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void addUser(User user) {
        String sql = "INSERT INTO users (cnic, role, license_no, name, address, phone_number) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getCnic());
            pstmt.setString(2, user.getRole());
            pstmt.setString(3, user.getLicenseNo());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getPhoneNumber());

            pstmt.executeUpdate();
            System.out.println("User added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding user.");
        }
    }
}