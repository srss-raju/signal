package com.deloitte.smt.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonRawValue;

@Data
@Entity
@Table(name = "sm_signal_audit")
public class SignalAudit   implements Serializable {

	private static final long serialVersionUID = -3652414302035277522L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String entityType;
	@Column(columnDefinition = "TEXT")
	@JsonRawValue
	private String originalValue;
	@Column(columnDefinition = "TEXT")
	@JsonRawValue
	private String modifiedValue;
	private String createdBy;
	private String modifieddBy;
	private Date createdDate;
	private Date modifiedDate;
	private String operation;
	
	@Transient
	private List<SignalAttachmentAudit> signalAttachmentAudit;

	
}
