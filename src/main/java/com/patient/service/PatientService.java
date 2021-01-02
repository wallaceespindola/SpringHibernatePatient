package com.patient.service;
 
import java.util.List;
import org.apache.log4j.Logger;

import com.patient.dao.PatientDao;
import com.patient.domain.Patient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
 
@Service
@Transactional
public class PatientService {
 
	protected static Logger logger = Logger.getLogger("PatientService");
 
	@Autowired
	private PatientDao patientDao;
 
	public List<Patient> getAllPatients() {		
		return patientDao.getAllPatients();		
	}
 
	public void addPatient(Patient patient) {		
		patientDao.addPatient(patient);
	}
 
}