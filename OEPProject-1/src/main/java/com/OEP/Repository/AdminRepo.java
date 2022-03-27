package com.OEP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.OEP.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	Admin findByNameAndPassword(String name, String password);
}
