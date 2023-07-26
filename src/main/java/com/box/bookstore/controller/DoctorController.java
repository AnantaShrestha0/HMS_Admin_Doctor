package com.box.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.box.bookstore.model.DoctorModel;
import com.box.bookstore.service.DoctorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/login")
	public String getlogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postlogin(DoctorModel doctortModel,Model model,HttpSession httpSession) {
		
		DoctorModel p=doctorService.findDoctor(doctortModel);
		if(p==null) {
			model.addAttribute("username_error","username or password not matched");
			return "login";
		}
		try {
		if(p.getRegistered().equals("yes")) {
			httpSession.setAttribute("validDoctor", p);
			httpSession.setMaxInactiveInterval(10000000);
			return "redirect:/appointmentRequestList";
		}
		}catch(Exception e) {
		
		
		int id=p.getId();
		model.addAttribute("doctorObject", doctorService.getDoctorId(id));
		
		return "doctorregistration";
		}
		int id=p.getId();
		model.addAttribute("doctorObject", doctorService.getDoctorId(id));
		
		return "doctorregistration";
	}
	
	@GetMapping("/signup")
	public String getsignup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postsignup(DoctorModel doctorModel,Model model) {
		
		String pass=doctorModel.getPassword();
		String conpass=doctorModel.getConpassword();
		DoctorModel p=doctorService.findSameEmail(doctorModel);
		if(p==null) {
		if(pass.equals(conpass)){
			doctorModel.setAuthorized("no");
			doctorService.addDoctor(doctorModel);
			return "login";
		}
		model.addAttribute("same_username_found", "Password not matched");
		return "signup";
		}
		model.addAttribute("same_username_found", "This email is already registered");
		return "signup";
		
	}
	
	
	
	@PostMapping("/registration")
	public String postregistration(DoctorModel doctorModel) {
		doctorModel.setRegistered("yes");
		doctorService.addDoctor(doctorModel);
		return "redirect:/doctor_interface";
		
	}

}
