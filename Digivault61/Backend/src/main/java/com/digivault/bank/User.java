package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	public Long userId;
    public Long getUserId() {
		return userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Column(name="first_name")
	public String firstName;
	@Column(name="last_name")
    public String lastName;
	
	public User() {
	}
	
	public User(Long userId, String firstName, String lastName, Long balance) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    public Object getProfilePicture() {
        throw new UnsupportedOperationException("Unimplemented method 'getProfilePicture'");
    }


}