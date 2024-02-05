package com.example.Audit_manager.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.Audit_manager.audit.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;






@Entity
@Table(name = "Audit_table")
@EntityListeners(AuditingEntityListener.class)
public class Employee extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Audit_id;
	
	
	//need foreign key from transaction table , i need to get it from from 
	@Column(name = "Transaction_id", nullable = false)
	private int Transaction_id;
	//employee created 
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "email_address", nullable = false)
	private String emailId;
	//log level
	
	@Column(name = "Log_Id", nullable = false)
	private int Log_Id;
	
	@Column(name = "Risk_Id", nullable = false)
	private int Risk_Id;
	
	@Column(name = "Entity_record_id", nullable = false)
	private int Entity_record_id;
	
	@Column(name = "Entity_table_name", nullable = false)
	private String Entity_table_name;
	
	@Column(name = "Audit_type", nullable = false)
	private String Audit_type;

	public long getAudit_id() {
		return Audit_id;
	}

	public void setAudit_id(long audit_id) {
		Audit_id = audit_id;
	}

	public int getTransaction_id() {
		return Transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		Transaction_id = transaction_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getLog_Id() {
		return Log_Id;
	}

	public void setLog_Id(int log_Id) {
		Log_Id = log_Id;
	}

	public int getRisk_Id() {
		return Risk_Id;
	}

	public void setRisk_Id(int risk_Id) {
		Risk_Id = risk_Id;
	}

	public int getEntity_record_id() {
		return Entity_record_id;
	}

	public void setEntity_record_id(int entity_record_id) {
		Entity_record_id = entity_record_id;
	}

	public String getEntity_table_name() {
		return Entity_table_name;
	}

	public void setEntity_table_name(String entity_table_name) {
		Entity_table_name = entity_table_name;
	}

	public String getAudit_type() {
		return Audit_type;
	}

	public void setAudit_type(String audit_type) {
		Audit_type = audit_type;
	}

	@Override
	public String toString() {
		return "Employee [Audit_id=" + Audit_id + ", Transaction_id=" + Transaction_id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailId=" + emailId + ", Log_Id=" + Log_Id + ", Risk_Id=" + Risk_Id
				+ ", Entity_record_id=" + Entity_record_id + ", Entity_table_name=" + Entity_table_name
				+ ", Audit_type=" + Audit_type + "]";
	}
	
	
	
	
	
	
	
	
}
