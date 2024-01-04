package com.Revpay.FavePay.repositories;

import com.Revpay.FavePay.entities.Trans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Trans, Long> {

}
