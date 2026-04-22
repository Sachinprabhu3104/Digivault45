package com.digivault.bank;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long Id;
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }


    @Override
	public String toString() {
		return "Transactions [id=" + Id + ", account_no=" + accountNo + ", transaction_type=" + transactionType +", amount=" + amount +", transcation_date=" + transactionDate +", comments="+ comments +"]";
    }
        public Transactions() {

        }
        
        public Transactions(Long id, Long userId, String accountNo, String transactionType, String amount,
             String comments, LocalDateTime transactionDate) {
            Id = id;
            this.userId = userId;
            this.accountNo = accountNo;
            this.transactionType = transactionType;
            this.amount = amount;
            this.transactionDate = transactionDate;
            this.comments = comments;
        }

        @Column(name="user_id")
        public Long userId;
        @Column(name="account_no")
        public String accountNo;
        @Column(name="transaction_type")
        public String transactionType;
        @Column(name="amount")
        public String amount;
        @CreationTimestamp
        @Column(name="transaction_date")
        public LocalDateTime transactionDate; 
        @Column(name="comments")
        public String comments;
        @Column(name="to_account")
        public String toAccount;
        public String getToAccount() {
            return toAccount;
        }

        public void setToAccount(String toAccount) {
            this.toAccount = toAccount;
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

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public LocalDateTime getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(LocalDateTime transactionDate) {
            this.transactionDate = transactionDate;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        } 

        
	}
    


