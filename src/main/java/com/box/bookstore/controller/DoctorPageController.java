package com.box.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.bookstore.api.AppointmentApi;
import com.box.bookstore.model.DoctorModel;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorPageController {

	@Autowired
	private AppointmentApi appointmentApi;
	
	@GetMapping("/doctor_interface")
	public String getAdminUserInterface(Model model,HttpSession httpSession) {
		DoctorModel doctorModel=(DoctorModel) httpSession.getAttribute("validDoctor");
		
		model.addAttribute("appointmentRequestList", appointmentApi.getAppointmentRequestList(doctorModel.getId()));
		return "appointmentRequestList";
	}
	
	
	@GetMapping("/appointmentRequestList")
	public String getAppointmentRequestList(Model model,HttpSession httpSession) {
		DoctorModel doctorModel=(DoctorModel) httpSession.getAttribute("validDoctor");
		model.addAttribute("appointmentRequestIndicator","active");
		model.addAttribute("appointmentRequestList", appointmentApi.getAppointmentRequestList(doctorModel.getId()));
		return "appointmentRequestList";
		
	}
	
	@GetMapping("/appointmentList")
	public String getAppointmentList(Model model,HttpSession httpSession) {
		DoctorModel doctorModel=(DoctorModel) httpSession.getAttribute("validDoctor");
		model.addAttribute("appointmentListIndicator", "active");
		model.addAttribute("appointmentList", appointmentApi.getAppointmentList(doctorModel.getId()));
		return "appointmentList";
	}
	
	@GetMapping("/appointmentCanceled")
	public String getAppointmentCanceledList(Model model,HttpSession httpSession) {
		
		DoctorModel doctorModel=(DoctorModel) httpSession.getAttribute("validDoctor");
		model.addAttribute("appointmentCancelIndicator", "active");
		model.addAttribute("appointmentList", appointmentApi.getAppointmentCanceledList(doctorModel.getId()));
		return "appointmentCanceledList";
		
	}
	
	
	

	
}
