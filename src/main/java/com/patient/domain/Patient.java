package com.patient.domain;
 
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
@Entity
@Table(name = "PATIENT")
public class Patient implements Serializable {
 
	private static final long serialVersionUID = 7498045397774366499L;
 
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;
 
	@Column(name = "PATIENT_TEXT")
	private String patientText;
 
	@Temporal(TemporalType.TIMESTAMP)
        @Column(name = "PATIENT_DATE")
	private Date patientDate;
 
	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}
 
	public String getPatientText() {
		return patientText;
	}
 
	public void setPatientText(String patientText) {
		this.patientText = patientText;
	}
 
	public Date getPatientDate() {
		return patientDate;
	}
 
	public void setPatientDate(Date patientDate) {
		this.patientDate = patientDate;
	} 
 
}