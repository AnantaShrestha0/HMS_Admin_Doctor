package com.box.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PatientMedicalDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int height;
	private int weight;
	private String gender;
	private String bloodpressure;
	private String bloodgroup;
	private int sugarlevel;
	
}
