package com.example.Audit_manager.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Audit_manager.model.Employee;
import com.example.Audit_manager.model.Modules;
import com.example.Audit_manager.model.Transaction;

import com.example.Audit_manager.repository.TransactionRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@PostMapping("/createeTransaction")
	public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	//getting 
	
	@GetMapping("/getTransactionDetails")
	public List<Transaction> getAllTransactionDetails() {
		return transactionRepository.findAll();
	}

}
