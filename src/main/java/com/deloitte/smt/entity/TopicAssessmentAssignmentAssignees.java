package com.deloitte.smt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Rajesh on 31-07-2017.
 */
@Entity
@Table(name = "sm_topic_assessment_assignment_assignees")
public class TopicAssessmentAssignmentAssignees implements Serializable{
	 
		/**
	 * 
	 */
	private static final long serialVersionUID = -6586959436931561167L;

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
		private Date createdDate;
	    private String createdBy;
	    private Date lastModifiedDate;
	    private String assignTo;
	    private String userGroupKey;
	    private String userKey;
	    
	    private Long assessmentId;
	    public TopicAssessmentAssignmentAssignees(){
			
		}
		
		public TopicAssessmentAssignmentAssignees( String userGroupKey,  String userKey){
			this.userKey = userKey;
			this.userGroupKey = userGroupKey;
		}
	    @Transient
	    @JsonIgnore
	    private AssessmentPlan assessmentPlan;
	    
	    @ManyToOne
		@JoinColumn(name = "assessmentId")
	    public AssessmentPlan getAssessmentPlan() {
			return assessmentPlan;
		}
		public void setAssessmentPlan(AssessmentPlan assessmentPlan) {
			this.assessmentPlan = assessmentPlan;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public String getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}

		public Date getLastModifiedDate() {
			return lastModifiedDate;
		}

		public void setLastModifiedDate(Date lastModifiedDate) {
			this.lastModifiedDate = lastModifiedDate;
		}

		public String getAssignTo() {
			return assignTo;
		}

		public void setAssignTo(String assignTo) {
			this.assignTo = assignTo;
		}

		public String getUserGroupKey() {
			return userGroupKey;
		}

		public void setUserGroupKey(String userGroupKey) {
			this.userGroupKey = userGroupKey;
		}

		public String getUserKey() {
			return userKey;
		}

		public void setUserKey(String userKey) {
			this.userKey = userKey;
		}

		public Long getAssessmentId() {
			return assessmentId;
		}

		public void setAssessmentId(Long assessmentId) {
			this.assessmentId = assessmentId;
		}
	    
		
}
