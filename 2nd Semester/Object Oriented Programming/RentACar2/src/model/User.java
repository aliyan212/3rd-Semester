package model;

public class User {
    private String cnic;
    private String role;
    private String licenseNo;
    private String name;
    private String address;
    private String phoneNumber;

    public User(String cnic, String role, String licenseNo, String name, String address, String phoneNumber) {
        this.cnic = cnic;
        this.role = role;
        this.licenseNo = licenseNo;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getCnic() { 
        return cnic;
     }
    public String getRole() { 
        return role; 
    }
    public String getLicenseNo() { 
        return licenseNo;
     }
    public String getName() { 
        return name; 
    }
    public String getAddress() { 
        return address;
     }
    public String getPhoneNumber() { 
        return phoneNumber;
     }
}