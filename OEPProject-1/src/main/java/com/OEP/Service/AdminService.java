package com.OEP.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OEP.Model.Admin;
import com.OEP.Model.Users;
import com.OEP.Repository.AdminRepo;
import com.OEP.Repository.UserRepo;

@Service
public class AdminService {
	@Autowired
	AdminRepo repo;
	
	 @Autowired
	    UserRepo repos;

	public Admin addAdmin(Admin e) {
		Admin emp = repo.save(e);
		return emp;
	}

	public Admin login(String name, String password) {
		Admin obj = repo.findByNameAndPassword(name, password);
		return obj;
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
   
    public Users addUser(Users u) {
        Users us = repos.save(u);
        return us;
    }
    public void deleteByname(String name) {
        repos.deleteByname(name);
    }
}

