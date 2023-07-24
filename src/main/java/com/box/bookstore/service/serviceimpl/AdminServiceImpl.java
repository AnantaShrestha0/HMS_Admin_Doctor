package com.box.bookstore.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.bookstore.model.AdminModel;
import com.box.bookstore.repo.Admin_repo;
import com.box.bookstore.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private Admin_repo admin_repo;

	@Override
	public AdminModel findAdmin(AdminModel adminModel) {
		// TODO Auto-generated method stub
		return admin_repo.findByEmailAndPassword(adminModel.getEmail(),adminModel.getPassword());
	}

	@Override
	public void changeEmailPassword(AdminModel adminModel) {
		// TODO Auto-generated method stub
		admin_repo.save(adminModel);
	}

}
