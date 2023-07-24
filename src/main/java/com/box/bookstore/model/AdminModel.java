package com.box.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class AdminModel {
	
	@Id
	private int id;
	private String email;
	private String password;
	private String gmail;
	private String changedpassword;
	@Transient
	private String cpassword;

}
