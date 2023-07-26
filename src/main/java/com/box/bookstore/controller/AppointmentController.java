package com.box.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.bookstore.api.AppointmentApi;
import com.box.bookstore.model.AppointmentModel;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppointmentController {

	
	@Autowired
	private AppointmentApi appointmentApi;
	
	@GetMapping("/appointmentRequestCancel")
	public String getAppointmentRequestCancel(@RequestParam int id,Model model,HttpSession httpSession)
	{
		appointmentApi.getAppointmentCancel(id);
		return "redirect:/appointmentRequestList";
	}
	
	@GetMapping("/appointmentAccept")
	public String getAppointmentAccept(@RequestParam int id,Model model,HttpSession httpSession) {
		appointmentApi.getAppointmentAccept(id);
		return "redirect:/appointmentRequestList";
	}
	
	
	
	@GetMapping("/appointmentViewDetails")
	public String getAppointmentViewDetails(@RequestParam int id,Model model,HttpSession session) {
		AppointmentModel appointmentModel=appointmentApi.getAppointment(id);
		model.addAttribute("appointmentObject", appointmentModel);
		return "appointment_view_details";
		
	}
	
}
