package com.OEP.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEP.Model.Admin;
import com.OEP.Model.UserPage;
import com.OEP.Repository.AdminRepo;
import com.OEP.Repository.UserRepo;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminRepo repo;

	@Autowired
	UserRepo repos;

	public Admin addAdmin(Admin a) {
		Admin ad = repo.save(a);
		return ad;
	}

	public void deleteById(int id) {
		repo.deleteById(id);

	}

	public Optional<Admin> findById(int id) {
		return repo.findById(id);
	}

	public void updateAdminById(Admin admin) {
		repo.save(admin);

	}

	public Admin login(String name, String password) {
		Admin obj = repo.findByNameAndPassword(name, password);
		return obj;
	}

	public UserPage addUser(UserPage u) {
		UserPage us = repos.save(u);
		return us;
	}

	public void deleteByname(String name) {
		repos.deleteByname(name);

	}

}
