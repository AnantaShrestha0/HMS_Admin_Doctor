package com.box.bookstore.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.box.bookstore.model.DoctorModel;
import com.box.bookstore.service.DoctorService;

@RestController
public class DoctorListApi {
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/api/doctorList")
	public List<DoctorModel> getAllPatient() {
		List<DoctorModel> allDoctor= doctorService.getAllDoctor();
		List<DoctorModel> authorizedDoctorList=new ArrayList<>();
		for(DoctorModel doctor:allDoctor) {
			String check="yes";
			String docauthorized=doctor.getAuthorized();
			if(docauthorized.equals(check)) {
			authorizedDoctorList.add(doctor);
			}
		}
		return authorizedDoctorList;
	}
	@GetMapping("/api/doctorName/{id}")
	public String getDoctorName(@PathVariable int id) {
		DoctorModel doctorModel=doctorService.getDoctorId(id);
		
		return doctorModel.getDoctorPersonalDetailsModel().getFullname();
	}
}
