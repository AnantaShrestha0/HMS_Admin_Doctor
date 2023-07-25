package com.box.bookstore.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.bookstore.model.AdminModel;
import com.box.bookstore.model.StaffModel;
import com.box.bookstore.service.AdminService;
import com.box.bookstore.service.StaffService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("/login")
	public String postAdmin(AdminModel adminModel,Model model,HttpSession httpSession) {
		AdminModel admin=adminService.findAdmin(adminModel);
		if(admin==null) {
			model.addAttribute("admin_error","Admin username and password not matched");
			return "adminlogin";
		}
		
//		if(changedpass.equals("yes")) {
//			model.addAttribute("adminObj",admin);
//			return "adminchangepassword";
//		}
		try {
		if(admin.getChangedpassword().equals("yes")) {
//			int n=p.getId();			
//			return "redirect:/patientinterface/"+n;
			httpSession.setAttribute("validAdmin",admin);
			return "redirect:/adminuserinterface";
		}
		}catch(Exception e) {
		
		
			model.addAttribute("adminObj",admin);
			return "adminchangepassword";
		
		}
		model.addAttribute("adminObj",admin);
		return "adminchangepassword";
       }
		

		
	@GetMapping("login")
	public String getAdminLogin() {
		return "adminlogin";
	}
	
	
	@PostMapping("/change_email_password")
	public String postChangeEmailPassword(AdminModel adminModel,Model model,HttpSession httpSession) {
		
//		if(httpSession.getAttribute("validAdmin")==null) {
//			return "adminlogin";
//		}
		
		String cpassword=adminModel.getCpassword();
		if(adminModel.getPassword().equals(cpassword)) {
			adminModel.setChangedpassword("yes");
		//	httpSession.setAttribute("validAdmin",adminModel);
			adminService.changeEmailPassword(adminModel);
			return "redirect:/adminuserinterface";
			
		}
		model.addAttribute("password_not_matched","Password not matched");
		model.addAttribute("adminObj", adminModel);
		return "adminchangepassword";
	}
	
	@PostMapping("/addStaff")
	public String postAddStaff(StaffModel staffModel,HttpSession httpSession) {
		if(httpSession.getAttribute("validAdmin")==null) {
			return "adminlogin";
		}
		staffService.addStaff(staffModel);
		return "redirect:/addStaff";
	}
	
	
	
	
	

}
