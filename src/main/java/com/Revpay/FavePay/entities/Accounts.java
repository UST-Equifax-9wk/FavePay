package com.Revpay.FavePay.entities;

import jakarta.persistence.*;
import java.text.DecimalFormat;


@Entity(name = "accounts")
public class Accounts {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column
    private Float balance;

    @Column
    private String transactions;

    @OneToOne
    @JoinColumn(name= "account_id") //, referencedColumnName = "user_id")
    private User user;

    public Accounts(Integer accountId, Float balance, String transactions) {
        this.accountId = accountId;
        this.balance = balance;
        this.transactions = transactions;
    }


    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getBalance() {
        return new DecimalFormat("0.00").format(balance);
    }

    public void setBalance(Float balance) {
        this.balance = balance;  //Float.parseFloat(balance);
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
