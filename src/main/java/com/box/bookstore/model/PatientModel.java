package com.box.bookstore.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class PatientModel {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String registered;
	@Transient
	private String conpassword;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_personal_detail_Id")
	private PatientPersonalDetailsModel patientPersonalDetailsModel;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="patient_medical_detail_Id")
//	private PatientMedicalDetailsModel patientMedicalDetailsModel;
	
	
}
