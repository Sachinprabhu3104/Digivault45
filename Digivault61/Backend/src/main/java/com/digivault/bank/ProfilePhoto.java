package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class ProfilePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "profile_picture", columnDefinition = "LONGTEXT")
    private String profilePicture;

    @Override
    public String toString() {
        return "ProfilePhoto [userId=" + userId + ", profilePicture=" + profilePicture + "]";
    }

    public ProfilePhoto() {
    }

    public Long getUserId() {
        return userId;
    }

    public ProfilePhoto(Long userId, String profilePicture) {
        this.userId = userId;
        this.profilePicture = profilePicture;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    

}
