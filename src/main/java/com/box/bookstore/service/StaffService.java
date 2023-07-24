package com.box.bookstore.service;

import java.util.List;

import com.box.bookstore.model.StaffModel;

public interface StaffService {

	void addStaff(StaffModel staffModel);
	List<StaffModel> getAllStaff();
	void deleteStaff(int id);
}
