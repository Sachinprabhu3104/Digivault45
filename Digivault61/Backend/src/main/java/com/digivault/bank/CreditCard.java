package com.digivault.bank;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "credit_cards")

public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationId;

    @Column(name = "users_id", nullable = false)
    private Integer usersId;

    @Column(name = "status", columnDefinition = "ENUM('Y','N')")
    private String status;

    @Column(name = "application_date", insertable = false, updatable = false)
    private Timestamp applicationDate;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Timestamp applicationDate) {
        this.applicationDate = applicationDate;
    }

    public CreditCard(Integer applicationId, Integer usersId, String status, Timestamp applicationDate) {
        this.applicationId = applicationId;
        this.usersId = usersId;
        this.status = status;
        this.applicationDate = applicationDate;
    }
    

}
