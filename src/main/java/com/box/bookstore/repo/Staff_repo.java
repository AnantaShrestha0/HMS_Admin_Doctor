package com.box.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.bookstore.model.StaffModel;

public interface Staff_repo extends JpaRepository<StaffModel, Integer>{

}
