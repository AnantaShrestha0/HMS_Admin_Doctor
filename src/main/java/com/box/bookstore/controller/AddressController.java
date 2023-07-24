package com.box.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

	@GetMapping("/location")
	public String getlocation() {
		return "redirect:https://www.google.com/maps/place/Morgan+International+College/@27.7390397,85.324997,17z/data=!3m1!4b1!4m6!3m5!1s0x39eb193a413ce887:0x42ae1db38b873ab6!8m2!3d27.739035!4d85.3275719!16s%2Fg%2F1tmxt_pg?entry=ttu";
	}
	
	@GetMapping("/facebook")
	public String getfacebook() {
		return "redirect:https://www.facebook.com/MorganIntlcollegeNepal/";
	}
	
	@GetMapping("/mail")
	public String getmail() {
		return "redirect:https://accounts.google.com/v3/signin/identifier?dsh=S134994020%3A1689691353914969&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AeDOFXhC4P9z36M0JHz-qCVOGgP-xG8IC20rSVYw8fC3GhfW9OuLY8t85XBE9Yk7m3IIg7S3jqy3BQ&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	}
}
