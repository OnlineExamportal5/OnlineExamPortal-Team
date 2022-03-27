package com.exam.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Model.Admin;
import com.exam.Repo.AdminRepo;

@Service
@Transactional
public class AdminService {
	@Autowired
	AdminRepo repo;

	public Admin addAdmin(Admin e) {
		Admin emp = repo.save(e);
		return emp;
	}

	public Admin login(String name, String password) {
		Admin obj = repo.findByNameAndPassword(name, password);
		return obj;
	}

	
}
