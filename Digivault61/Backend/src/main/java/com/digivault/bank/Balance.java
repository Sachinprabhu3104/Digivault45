package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="account_no")
    public String accountNo;
    @Column(name="balance")
    public String balance;
    public String getAccountNo() {
        return accountNo;
    }
    public Balance() {
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    @Override
    public String toString() {
        return "Balance [accountNo=" + accountNo + ", balance=" + balance + "]";
    }
    public Balance(String accountNo, String balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }  

}
