package com.digivault.bank;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long Id;

    @Override
	public String toString() {
		return "Accounts [id=" + Id + ", user_id=" + userId + ", account_no=" + accountNo + ", account_type=" + accountType +", balance=" + balance +"]";
	}
    
	public Accounts() {
    }

    public Accounts(Long accountId, Long id, Long userId, String accountNo, String accountType, String balance) {
        this.accountId = accountId;
        Id = id;
        this.userId = userId;
        this.accountNo = accountNo;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }

    public Long accountId;
    public Accounts(Long accountId) {
        this.accountId = accountId;
    }
    public Long getAccountId() {
        return accountId;
    }
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Column(name="user_id")
	public Long userId;
	@Column(name="account_no")
    public String accountNo;
    @Column(name="account_type")
    public String accountType;
    @Column(name="balance")
    public String balance;  


}
