package com.rajivderas.saga.payment.repository;


import com.rajivderas.saga.payment.entity.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTransactionRepository extends JpaRepository<UserTransaction, Integer> {
}
