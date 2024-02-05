package com.example.Audit_manager.model;



import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.Audit_manager.audit.Transactionn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction_table")
@EntityListeners(AuditingEntityListener.class)
public class Transaction extends Transactionn <String>{
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int transactionId;

//	    @ManyToOne
//	    @JoinColumn(name = "module_id")
//	    private Module module;
	 

	  
	  
	
	@Column(name = "transactionType", nullable = false)
	    private String transactionType; // Created, Updated, Deleted
	  
	  @Column(name = "description", nullable = false)
	    private String description; //description
	  
	  @Column(name = "Transaction_status", nullable = false)
	  private String Transaction_status;
	  
	  
	  
	  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinColumn(name = "module_Id_FK", referencedColumnName = "moduleId")
	    @JsonIgnoreProperties("Transactions")
	    private Modules modules;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	
	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransaction_status() {
		return Transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		Transaction_status = transaction_status;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", description="
				+ description + ", Transaction_status=" + Transaction_status + "]";
	}

	
	  
	  
	
	  
	  
	  
	  
	  
	

	
	
	
	  
	  
	  
	  
	  
	  
	  

	  
	  

	  

	
	
	
	  
	
		
	  
	   

}
