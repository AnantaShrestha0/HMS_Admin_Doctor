package com.box.bookstore.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.box.bookstore.model.PatientModel;


@RestController
public class PatientListApi {

	@GetMapping("/api/patientList")
	public List<PatientModel> getPatientList() {
		RestTemplate restTemplate=new RestTemplate();
		PatientModel[] patientList=restTemplate.getForObject("http://localhost:8080/api/patientList",PatientModel[].class);
		List<PatientModel> patlist=List.of(patientList);
	    return patlist;

	}

//	@Autowired
//	private Patient_repo patient_repo;
//	
//	@GetMapping("/api/patientlist")
//	public void getPatientList() {
//		RestTemplate restTemplate=new RestTemplate();
//		PatientModel[] patientList=restTemplate.getForObject("http://localhost:8080/api/patientlist",PatientModel[].class);
//	     patient_repo.saveAll(List.of(patientList));
//	    
//	}
//	
//	@GetMapping("/api/p")
//	public List<PatientModel> p(){
//		List<PatientModel> list=patient_repo.findAll();
//		return list;
//	}
	
	
	@GetMapping("/api/patient")
	public PatientModel getPatient(int id) {
		String url="http://localhost:8080/api/patient/"+id;
		RestTemplate restTemplate=new RestTemplate();
		PatientModel patient=restTemplate.getForObject(url,PatientModel.class);
		return patient;
	}
	
	
	
	
	
	}

	
	
	

