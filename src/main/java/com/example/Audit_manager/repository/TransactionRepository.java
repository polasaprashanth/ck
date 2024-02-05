package com.example.Audit_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Audit_manager.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
