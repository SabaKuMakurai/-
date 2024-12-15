package model;

public class User {
    private String userID;
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String fullName;
    private int userType;  
    private int gender;    

    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getUserType() { return userType; }
    public void setUserType(int userType) { this.userType = userType; }

    public int getGender() { return gender; }
    public void setGender(int gender) { this.gender = gender; }
}
