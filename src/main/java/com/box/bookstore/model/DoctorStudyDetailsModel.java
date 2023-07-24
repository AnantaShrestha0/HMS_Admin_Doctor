package com.box.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DoctorStudyDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String degree;
	private String cgpa;
	private String specialist;
	private String grade;
	private String passoutyear;
	private String experience;
	
}
