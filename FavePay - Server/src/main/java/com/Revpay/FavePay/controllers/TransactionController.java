package com.Revpay.FavePay.controllers;

import com.Revpay.FavePay.entities.Trans;
import com.Revpay.FavePay.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
@RequestMapping("transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getTrans")
    public ResponseEntity<List<Trans>> getAllTransactions(){
        List<Trans> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
}
