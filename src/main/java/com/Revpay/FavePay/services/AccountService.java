package com.Revpay.FavePay.services;

import com.Revpay.FavePay.entities.Accounts;
import com.Revpay.FavePay.entities.Auth;
import com.Revpay.FavePay.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Optional<Accounts> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public void create(Auth newUser) {

    }
}