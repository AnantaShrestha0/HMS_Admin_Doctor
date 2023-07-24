package com.box.bookstore.service;

import java.util.List;

import com.box.bookstore.model.DoctorModel;

public interface DoctorService {
	
	void addDoctor(DoctorModel doctorModel);
	DoctorModel findDoctor(DoctorModel doctorModel);
	DoctorModel findSameEmail(DoctorModel doctorModel);
	DoctorModel getDoctorId(int id);
	List<DoctorModel> getAllDoctor();
	void deleteDoctor(int id);
	void acceptDoctor(int id);

}
