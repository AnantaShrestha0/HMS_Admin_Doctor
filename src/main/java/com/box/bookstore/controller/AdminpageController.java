package com.box.bookstore.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.bookstore.api.PatientListApi;
import com.box.bookstore.model.DoctorModel;
import com.box.bookstore.model.PatientModel;
import com.box.bookstore.model.StaffModel;
import com.box.bookstore.service.DoctorService;
import com.box.bookstore.service.StaffService;

@Controller
public class AdminpageController {
	
	@Autowired
	private PatientListApi patientListApi;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private StaffService staffService;
	
	
	
	@GetMapping("/adminuserinterface")
	public String getAdminUserInterface(Model model) {
		model.addAttribute("indexIndicator","active");
		return "adminuserinterface";
	}
	
	@GetMapping("/patientlist")
	public String getAllPatientList(Model model) {
		try {
		List<PatientModel> patientlist=patientListApi.getPatientList();
		model.addAttribute("patient_list", patientlist);
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("patientListIndicator","active");
			return "serverError";
		}
		model.addAttribute("patientListIndicator","active");
		return "adminpatientlist";
	}
	
	
//	@GetMapping("/patientlist")
//	public String getAllPatientList(Model model) {
//		patientListApi.getPatientList();
//		List<PatientModel> pp=patientListApi.p();
//		model.addAttribute("patient_list",pp);
//		model.addAttribute("patientListIndicator","active");
//	    return "adminpatientlist";
//	}
	
	
	
	@GetMapping("/doctorlist")
	public String getAllDoctorList(Model model) {
		List<DoctorModel> doctorModels=doctorService.getAllDoctor();
		List<DoctorModel> doctorList = null;
		doctorList=new ArrayList<>();
		for(DoctorModel doctor:doctorModels) {
			String authorized=doctor.getAuthorized();
			String ob="yes";
			if(authorized.equals(ob)) {
				doctorList.add(doctor);
			}
		}
		model.addAttribute("doctorListIndicator","active");
		model.addAttribute("doctor_list", doctorList);
 		return "admin_doctor_list";
	}
	

	@GetMapping("/doctorRequestlist")
	public String getAllDoctorRequestList(Model model) {
		List<DoctorModel> doctorModels=doctorService.getAllDoctor();
		List<DoctorModel> doctorList = null;
		doctorList=new ArrayList<>();
	for(DoctorModel doctor:doctorModels) {
			String authorized=doctor.getAuthorized();
			String ob="no";
			if(authorized.equals(ob)) {
				doctorList.add(doctor);
			}
		
	}
	    	
	    model.addAttribute("doctorRequestListIndicator","active");
		model.addAttribute("doctor_list", doctorList);
 		return "admin_doctor_request_list";
	}
	
	@GetMapping("/deleteRequestDoctor")
	public String getDeleteRequestDoctor(@RequestParam int id) {
		doctorService.deleteDoctor(id);
		return "redirect:/doctorRequestlist";
	}
	
	@GetMapping("/deleteDoctor")
	public String getDeleteDoctor(@RequestParam int id) {
		doctorService.deleteDoctor(id);
		return "redirect:/doctorlist";
	}
	
	@GetMapping("/acceptDoctor")
	public String getAcceptDoctor(@RequestParam int id) {
		doctorService.acceptDoctor(id);
		return "redirect:/doctorRequestlist";
	}
	
	@GetMapping("/addStaff")
	public String getAddStaff(Model model){
		model.addAttribute("addStaffIndicator","active");
		return "admin_add_staff";
	}
	
	@GetMapping("/staffList")
	public String getAllist(Model model) {
		List<StaffModel> stafflist=staffService.getAllStaff();
		model.addAttribute("staffListIndicator","active");
		model.addAttribute("staff_list",stafflist);
		return "admin_staff_list";
	}
	
	@GetMapping("/deleteStaff")
	public String getDeleteStaff(@RequestParam int id) {
		staffService.deleteStaff(id);
		return "redirect:/staffList";
	}
	
	@GetMapping("/adminContact")
	public String getAdminContact(@RequestParam String gmail,Model model) {
		model.addAttribute("gmail",gmail);
		return "admin_contact";
	}
	
	
	@GetMapping("/viewDoctorDetails")
	public String getadminasjdn(@RequestParam int id,Model model) {
		DoctorModel doctorModel=doctorService.getDoctorId(id);
		model.addAttribute("doctorObject", doctorModel);
		return "admin_view_doctor_details";
	}
	
	@GetMapping("/viewPatientDetails")
	public String getadminViewPatient(@RequestParam int id,Model model) {
	
		//model.addAttribute("doctorObject", doctorModel);
		return "admin_view_doctor_details";
	}

}