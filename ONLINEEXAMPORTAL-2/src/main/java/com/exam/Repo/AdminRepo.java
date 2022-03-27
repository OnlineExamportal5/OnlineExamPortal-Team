package com.exam.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.Model.Admin;



@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
	
	 Admin findByNameAndPassword(String name,String password); 
		/*
		 * List<Admin>findByNameAndPassword(String name,String password);
		 */
}
