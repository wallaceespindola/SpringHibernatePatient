package com.patient.web.form;
 
import com.patient.domain.Color;
import com.patient.domain.Patient;
 
public class PatientForm {
 
	//the domain model persistent data
	private Patient patient;
 
	//the other non persistent data ... used in user interface only
	private Color color;
 
	public Patient getPatient() {
		return patient;
	}
 
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
 
	public Color getColor() {
		return color;
	}
 
	public void setColor(Color color) {
		this.color = color;
	}
 
}