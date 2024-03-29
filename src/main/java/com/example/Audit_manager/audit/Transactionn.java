package com.example.Audit_manager.audit;

import static jakarta.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Transactionn <U> {
	
	 	@CreatedBy
	    protected U createdBy;

	    @CreatedDate
	    @Temporal(TIMESTAMP)
	    protected Date createdDate;

	    @LastModifiedBy
	    protected U lastModifiedBy;

	    @LastModifiedDate
	    @Temporal(TIMESTAMP)
	    protected Date lastModifiedDate;

	    public U getCreatedBy() {
	        return createdBy;
	    }

	    public void setCreatedBy(U createdBy) {
	        this.createdBy = createdBy;
	    }

	    public Date getCreatedDate() {
	        return createdDate;
	    }

	    public void setCreatedDate(Date createdDate) {
	        this.createdDate = createdDate;
	    }

	    public U getLastModifiedBy() {
	        return lastModifiedBy;
	    }

	    public void setLastModifiedBy(U lastModifiedBy) {
	        this.lastModifiedBy = lastModifiedBy;
	    }


}
