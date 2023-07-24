package com.box.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontpageController {

	
	    @GetMapping("/")
	    public String home(Model model) {
	    	model.addAttribute("indexindicator","active");
	    	return "index";
	    }
	    
         
	    @GetMapping("/admin")
	    public String getAdmin() {
	    	return "adminlogin";
	    }
		

	    
	    
	 
}
