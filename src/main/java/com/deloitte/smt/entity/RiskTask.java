package com.deloitte.smt.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "sm_risk_task")
public class RiskTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String riskId;
	
	private String name;
	
	private String description;
	
	private Date dueDate;

	private Date createdDate;

	private Date lastUpdatedDate;

	private String lastUpdatedBy;

	private String notes;
	
	private String caseInstanceId;
	
    private String taskId;
    
    private String status;

	private String actionType;

	private String createdBy;
	
	private String recipients;
	@Transient
	private Map<String, Attachment> fileMetadata;
	@Transient
	private List<Long> deletedAttachmentIds;
	
	@Transient
    private List<SignalURL> signalUrls;

	private String assignTo;
	private String owner;
	
	private Long templateId;
	
	private Long inDays;

}
