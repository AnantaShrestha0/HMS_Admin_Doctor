package com.box.bookstore.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.bookstore.model.DoctorModel;
import com.box.bookstore.repo.Doctor_repo;
import com.box.bookstore.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private Doctor_repo doctor_repo;
	
	@Override
	public void addDoctor(DoctorModel patientModel) {
		// TODO Auto-generated method stub
		doctor_repo.save(patientModel);
		
		
	}

	@Override
	public DoctorModel findDoctor(DoctorModel patientModel) {
		// TODO Auto-generated method stub
		String email=patientModel.getEmail();
		String password=patientModel.getPassword();
		
		return doctor_repo.findByEmailAndPassword(email, password);
	}

	@Override
	public DoctorModel findSameEmail(DoctorModel patientModel) {
		// TODO Auto-generated method stub
		String email=patientModel.getEmail();
		
		
		return doctor_repo.findByEmail(email);
	}

	@Override
	public DoctorModel getDoctorId(int id) {
		// TODO Auto-generated method stub
		return doctor_repo.findById(id).get();
		
	}

	@Override
	public List<DoctorModel> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctor_repo.findAll();
	}

	@Override
	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		doctor_repo.deleteById(id);
	}

	@Override
	public void acceptDoctor(int id) {
		// TODO Auto-generated method stub
		DoctorModel doctorModel=doctor_repo.findById(id).get();
		doctorModel.setAuthorized("yes");
		doctor_repo.save(doctorModel);
	}

}
