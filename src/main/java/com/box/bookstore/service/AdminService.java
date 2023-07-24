package com.box.bookstore.service;

import com.box.bookstore.model.AdminModel;

public interface AdminService {
	
	AdminModel findAdmin(AdminModel adminModel);
	
	void changeEmailPassword(AdminModel adminModel);

}
