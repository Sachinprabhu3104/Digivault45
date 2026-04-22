package com.digivault.bank;

public class PasswordChangeRequest {

    private Long userId;
    private String newPassword;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public PasswordChangeRequest(Long userId, String newPassword) {
        this.userId = userId;
        this.newPassword = newPassword;
    }

    
    

}
