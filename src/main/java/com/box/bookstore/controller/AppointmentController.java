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
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		appointmentApi.getAppointmentCancel(id);
		return "redirect:/appointmentRequestList";
	}
	
	@GetMapping("/appointmentAccept")
	public String getAppointmentAccept(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		appointmentApi.getAppointmentAccept(id);
		return "redirect:/appointmentRequestList";
	}
	
	
	
	@GetMapping("/appointmentViewDetailsForRequest")
	public String getAppointmentViewDetailsForRequest(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		AppointmentModel appointmentModel=appointmentApi.getAppointment(id);
		model.addAttribute("appointmentRequestListIndicator","active");  
		model.addAttribute("appointmentObject", appointmentModel);
		return "appointment_view_details_for_request";
		
	}
	
	@GetMapping("/appointmentViewDetailsForAccepted")
	public String getAppointmentViewDetailsForAccepted(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		AppointmentModel appointmentModel=appointmentApi.getAppointment(id);
		model.addAttribute("appointmentAcceptedListIndicator", "active");
		model.addAttribute("appointmentObject", appointmentModel);
		return "appointment_view_details_for_accepted";
		
	}
	
	@GetMapping("/appointmentViewDetailsForCancel")
	public String getAppointmentViewDetailsForCancel(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		AppointmentModel appointmentModel=appointmentApi.getAppointment(id);
		model.addAttribute("appointmentCancelListIndicator", "active");
		model.addAttribute("appointmentObject", appointmentModel);
		return "appointment_view_details_for_canceled";
		
	}
	
	@GetMapping("/appointmentAcceptedCancel")
	public String getAppointmentAcceptedCancel(@RequestParam int id,Model model,HttpSession httpSession)
	{
		
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		appointmentApi.getAppointmentCancel(id);
		return "redirect:/appointmentAcceptedList";
	}
	
	
	@GetMapping("/appointmentDelete")
	public String getAppointmentDelete(@RequestParam int id,Model model,HttpSession httpSession) {
		
		if(httpSession.getAttribute("validDoctor")==null) {
			return "login";
		}
		
		appointmentApi.getAppointmentDelete(id);
		return "redirect:/appointmentCanceledList";
	}
	
	
	
}
