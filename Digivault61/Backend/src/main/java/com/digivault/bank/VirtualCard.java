package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "virtual_cards")
public class VirtualCard {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Integer userId;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ACTIVE, BLOCKED
    }
    
    public VirtualCard() {
    }

    // Constructor for creating new VirtualCard instances
    public VirtualCard(Integer userId, String cardNumber, String expiryDate, String cvv, Status status) {
        this.userId = userId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        if (status == null) {
            status = Status.ACTIVE;
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
