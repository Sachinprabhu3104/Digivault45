package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "payeedetails")
public class PayeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNo;

    private Long userId;

    private String payeeAccountNo;

    private String ifscCode;

    private String bankName;

    private String accountType;

    private String customerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public PayeeDetails(Long id, String accountNo, Long userId, String payeeAccountNo, String ifscCode, String bankName,
            String accountType, String customerName) {
        this.id = id;
        this.accountNo = accountNo;
        this.userId = userId;
        this.payeeAccountNo = payeeAccountNo;
        this.ifscCode = ifscCode;
        this.bankName = bankName;
        this.accountType = accountType;
        this.customerName = customerName;
    }

    
}
