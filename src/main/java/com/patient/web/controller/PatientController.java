package com.patient.web.controller;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Date;
import org.apache.log4j.Logger;

import com.patient.domain.Color;
import com.patient.domain.Patient;
import com.patient.service.PatientService;
import com.patient.web.form.PatientForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/home")
public class PatientController {
 
	protected static Logger logger = Logger.getLogger("PatientController");
 
	private PatientService patientService;
 
	@Autowired 
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
 
        //note there is no actual patients.html file!! 
	@RequestMapping(value = "/addpatient.html", method = RequestMethod.GET)
        public String showAddPatientPage(@ModelAttribute("patientform") PatientForm patientForm) {		
 
		logger.info("entering showAddPatientPage()");
 
		//no need to add colorlist to the model anymore since it is defined at method level below
		//no need to have the model object in this method either
 
    	        //resolves to /WEB-INF/jsp/addpatient.jsp
    	        return "addpatient";
	}	
 
	@ModelAttribute("colorlist")
	public List<Color> populateColorList() {
		//color list is hardcoded for now...
		List<Color> colorList = new ArrayList<Color>();
		colorList.add(new Color("Indian Red", "F75D59"));
		colorList.add(new Color("Red", "FF0000"));
		colorList.add(new Color("Salmon", "F9966B"));
		colorList.add(new Color("Lemon Chiffon", "FFF8C6"));
		colorList.add(new Color("Olive Green", "BCE954"));
		colorList.add(new Color("Steel Blue", "C6DEFF"));
		colorList.add(new Color("Medium Purple", "9E7BFF"));
		return colorList;
	}	
 
	@RequestMapping(value = "/patients.html", method = RequestMethod.POST)
	public String addPatientAndShowAll(@ModelAttribute("patientform") PatientForm patientForm,
			Map<String, Object> model) {		
 
		logger.info("entering addPatientAndShowAll()");
 
		Patient patient = patientForm.getPatient();
                patient.setPatientDate(new Date());
		patientService.addPatient(patient);  
 
		List<Patient> patients = patientService.getAllPatients();
		model.put("patientlist", patients);
 
	    	String selectedColorCode=patientForm.getColor().getColorCode(); 
	    	if(selectedColorCode.equals("")) { //if no color selected, then make default white
	    		selectedColorCode="FFFFFF";
                }
	    	model.put("colorcode", selectedColorCode);
 
	    	// This will resolve to /WEB-INF/jsp/patients.jsp
	    	return "patients";
	} 
 
	//define the same url with GET so users can skip to the patients page
	@RequestMapping(value = "/patients.html", method = RequestMethod.GET)
	public String showAllPatients(Map<String, Object> model) {		
 
		logger.info("entering showAllPatients");
 
		List<Patient> patients = patientService.getAllPatients();
		model.put("patientlist", patients);		
		model.put("colorcode", "FFFFFF");
 
	    	// This will resolve to /WEB-INF/jsp/patients.jsp
	    	return "patients";
	}
 
}