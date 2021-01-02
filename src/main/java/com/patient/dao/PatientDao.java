package com.patient.dao;
 
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.patient.domain.Patient;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository
public class PatientDao {
 
	protected static Logger logger = Logger.getLogger("PatientDao");
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public List<Patient> getAllPatients() {
		Session session = sessionFactory.getCurrentSession();		
		Query q = session.createQuery("select g from Patient g order by id desc");
		List<Patient> patientList = q.list(); 
	        return patientList;			
	}
 
	public void addPatient(Patient patient) {
		Session session = sessionFactory.getCurrentSession();	
		session.save(patient);
	}
 
}