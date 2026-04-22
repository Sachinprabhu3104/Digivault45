package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email_id",unique = true)
    private String emailId;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "admin_flag")
    private String adminFlag;

    @Column(name = "active_flag")
    private String activeFlag;

    @Column(name = "profile_picture", columnDefinition = "LONGTEXT")
    private String profilePicture;

    // Add No-Argument Constructor (Fixes Your Error)
    public Users() {
    }

    // Parameterized Constructor
    public Users(Long userId, String firstName, String lastName, String mobileNo, String gender, String emailId,
                 String password, String address, String adminFlag, String activeFlag,String profilePicture) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNo = mobileNo;
        this.gender = gender;
        this.emailId = emailId;
        this.password = password;
        this.address = address;
        this.adminFlag = adminFlag;
        this.activeFlag = activeFlag;
    }

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getAdminFlag() { return adminFlag; }
    public void setAdminFlag(String adminFlag) { this.adminFlag = adminFlag; }
    public String getActiveFlag() { return activeFlag; }
    public void setActiveFlag(String activeFlag) { this.activeFlag = activeFlag; }
    public String getProfilePicture() {
        return profilePicture;
    }
    
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Users(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    // Fixed toString() Method
    @Override
    public String toString() {
        return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName +
               ", mobileNo=" + mobileNo + ", gender=" + gender + ", emailId=" + emailId +
               ", password=" + password + ", address=" + address + ", adminFlag=" + adminFlag +
               ", activeFlag=" + activeFlag + ",profilePicture=" + profilePicture +"]";
    }
}
