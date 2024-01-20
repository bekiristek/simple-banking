package com.bekiristek.bankingapp.repository;

import com.bekiristek.bankingapp.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
