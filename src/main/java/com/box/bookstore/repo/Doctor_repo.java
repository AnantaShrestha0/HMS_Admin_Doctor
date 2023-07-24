package com.box.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.box.bookstore.model.DoctorModel;

public interface Doctor_repo extends JpaRepository<DoctorModel, Integer> {

	DoctorModel findByEmailAndPassword(String email,String password);

	DoctorModel findByEmail(String email);
}
