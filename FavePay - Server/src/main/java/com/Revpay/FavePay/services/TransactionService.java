package com.Revpay.FavePay.services;

import com.Revpay.FavePay.entities.Trans;
import com.Revpay.FavePay.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        //this.userService = userService;
        this.transactionRepository = transactionRepository;
        }

    public List<Trans> getAllTransactions(){
        return getAllTransactions();
    }
}
