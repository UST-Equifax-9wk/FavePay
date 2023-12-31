package com.Revpay.FavePay.repositories;

import com.Revpay.FavePay.entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {
    //Optional<Accounts> findById(Long id);
}
