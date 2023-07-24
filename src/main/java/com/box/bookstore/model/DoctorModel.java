package com.box.bookstore.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class DoctorModel {
    
	@Id
	@GeneratedValue
	private int id;
	private String email;
	private String password;
	private String registered;
	private String authorized;
	@Transient
	private String conpassword;
	

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_personal_details_Id")
	private DoctorPersonalDetailsModel doctorPersonalDetailsModel;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_study_details_Id")
	private DoctorStudyDetailsModel doctorStudyDetailsModel;
	
	
}
