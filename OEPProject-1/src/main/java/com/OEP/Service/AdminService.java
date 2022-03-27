package com.OEP.Service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.OEP.Model.Admin;
	import com.OEP.Repository.AdminRepo;
	@Service
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


