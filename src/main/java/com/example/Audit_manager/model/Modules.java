package com.example.Audit_manager.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Module_table")
public class Modules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    // other fields
    
    @Column(name = "module_name", nullable = false)
	private String module_name;
    
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "modules", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("modules")
    private List<Transaction> transaction = new ArrayList<>();
    
    
    
    public Modules()
    {
    	
    }
    

	public Modules(Long moduleId, String module_name, List<Transaction> transaction) {
		super();
		this.moduleId = moduleId;
		this.module_name = module_name;
		this.transaction = transaction;
	}


	public Long getModuleId() {
		return moduleId;
	}


	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}


	public String getModule_name() {
		return module_name;
	}


	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}


	public List<Transaction> getTransaction() {
		return transaction;
	}


	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}


	@Override
	public String toString() {
		return "Modules [moduleId=" + moduleId + ", module_name=" + module_name + ", transaction=" + transaction + "]";
	}





	

    
    
    
    
    

    
    
}
