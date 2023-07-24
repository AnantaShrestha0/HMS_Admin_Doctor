package com.box.bookstore.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.bookstore.model.StaffModel;
import com.box.bookstore.repo.Staff_repo;
import com.box.bookstore.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private Staff_repo staff_repo;
	
	@Override
	public void addStaff(StaffModel staffModel) {
		// TODO Auto-generated method stub
		staff_repo.save(staffModel);
	}

	@Override
	public List<StaffModel> getAllStaff() {
		// TODO Auto-generated method stub
		return staff_repo.findAll();
	}

	@Override
	public void deleteStaff(int id) {
		// TODO Auto-generated method stub
		staff_repo.deleteById(id);
	}

}
