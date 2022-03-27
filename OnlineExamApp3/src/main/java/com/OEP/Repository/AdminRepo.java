package com.OEP.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OEP.Model.Admin;

@Repository
//@Transactional
public interface AdminRepo extends JpaRepository<Admin, Integer> {
	Optional<Admin> findById(int id);

	public void deleteById(int id);

	Admin findByNameAndPassword(String name, String password);

}
