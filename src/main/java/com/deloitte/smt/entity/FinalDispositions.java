package com.deloitte.smt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Created by myelleswarapu on 02-05-2017.
 */
@Data
@Entity
@Table(name = "sm_final_dispositions")
public class FinalDispositions implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9115830195565829065L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdDate;
    private String createdBy;
    private Date lastModifiedDate;
    private String name;
    private String description;

   
}
