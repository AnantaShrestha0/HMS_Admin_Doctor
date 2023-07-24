package com.box.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.box.bookstore.util.MailUtil;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {

	@Autowired
	private MailUtil mailUtil;
	
	
	@PostMapping("/adminContact")
	public String postAdminContact(@RequestParam String email,@RequestParam String subject,@RequestParam String message,RedirectAttributes redirectAttributes) {
		mailUtil.sendEmail(email,subject,message);
		redirectAttributes.addAttribute("gmail", email);
		return "redirect:/adminContact";
	}
	
	@PostMapping("/doctorContact")
	public String postDoctorContact(@RequestParam String email,@RequestParam String subject,@RequestParam String message,RedirectAttributes redirectAttributes) {
		mailUtil.sendEmail(email,subject,message);
		redirectAttributes.addAttribute("gmail", email);
		return "redirect:/doctorContact";
	}
	

}
