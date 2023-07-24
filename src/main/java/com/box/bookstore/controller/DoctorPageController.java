package com.box.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorPageController {

	
	@GetMapping("/doctor_interface")
	public String getAdminUserInterface() {
		return "doctoruserinterface";
	}
	
	
}
