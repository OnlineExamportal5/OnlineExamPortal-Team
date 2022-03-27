package com.OEP.Repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OEP.Model.UserPage;

@Repository

public interface UserRepo extends JpaRepository<UserPage, Integer> {

	UserPage findByNameAndPassword(String name, String password);



	void deleteByname(String name);

}
