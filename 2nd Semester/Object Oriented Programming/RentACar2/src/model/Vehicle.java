package model;

public class Vehicle {
    private int vehicleId; 
    private String model;
    private String status;
    private double purchasePrice;
    private double ownershipPercentage;

    public Vehicle(String model, String status, double purchasePrice, double ownershipPercentage) {
        this.model = model;
        this.status = status;
        this.purchasePrice = purchasePrice;
        this.ownershipPercentage = ownershipPercentage;
    }

    public String getModel() { 
        return model; 
    }
    public String getStatus() { 
        return status; 
    }
    public double getPurchasePrice() {
         return purchasePrice; 
        }
    public double getOwnershipPercentage() { 
        return ownershipPercentage; 
    }
}
