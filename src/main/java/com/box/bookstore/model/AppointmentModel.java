package com.box.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AppointmentModel {
	
	@Id
	@GeneratedValue
	private int id;
	private int patientid;
	private String patient_name;
	private String doctorId;
	private String doctor_name;
	private String phonenumber;
	private String symptoms;
	private int age;
	private String bloodPressure;
	private String gender;
	private String passMedicalHistory;
	private String appointmentdate;
	private String appointmentStatus;
	private String patientCancel;
	
	

}
