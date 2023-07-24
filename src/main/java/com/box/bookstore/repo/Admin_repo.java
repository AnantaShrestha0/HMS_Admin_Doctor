package com.box.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.bookstore.model.AdminModel;

public interface Admin_repo extends JpaRepository<AdminModel, Integer>{

	AdminModel findByEmailAndPassword(String email,String password);
}
