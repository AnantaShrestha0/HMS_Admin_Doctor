package com.box.bookstore.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.box.bookstore.model.AppointmentModel;
import com.box.bookstore.model.PatientModel;

@RestController
public class AppointmentApi {

	
	@GetMapping("/api/appointmentRequestList")
	public List<AppointmentModel> getAppointmentRequestList(int id) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/appointmentRequestList/"+id;
		AppointmentModel[] appointmentRequestList=restTemplate.getForObject(url,AppointmentModel[].class);
		List<AppointmentModel> apreqlist=List.of(appointmentRequestList);
	    return apreqlist;

	}
	
	@GetMapping("/api/appointmentList")
	public List<AppointmentModel> getAppointmentAcceptedList(int id){
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/appointmentList/"+id;
		AppointmentModel[] appointmentList=restTemplate.getForObject(url, AppointmentModel[].class);
		List<AppointmentModel> applist=List.of(appointmentList);
		return applist;
		
	}
	
	@GetMapping("/api/appointmentCanceledList")
	public List<AppointmentModel> getAppointmentCanceledList(int id){
		
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/appointmentCancelList/"+id;
		AppointmentModel[] appointmentCanceledList=restTemplate.getForObject(url, AppointmentModel[].class);
		List<AppointmentModel> appcanceledlist=List.of(appointmentCanceledList);
		return appcanceledlist;
	}
	
	@GetMapping("/api/appointmentCancel")
	public void getAppointmentCancel(int id) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/appointmentCanceled/"+id;
		restTemplate.getForObject(url, void.class);
	}
	
	@GetMapping("/api/appointmentAccept")
	public void getAppointmentAccept(int id) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/appointmentApprove/"+id;
		restTemplate.getForObject(url, void.class);
	}
	
	@GetMapping("/api/appointmentDelete")
	public void getAppointmentDelete(int id) {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/delete/"+id;
		restTemplate.getForObject(url, void.class);
	}
	
	@GetMapping("/api/appointmentDetails")
	public AppointmentModel getAppointment(int id) {
	
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/api/appointmentDetails/"+id;
		
		return restTemplate.getForObject(url, AppointmentModel.class);
		
	}
	
}
